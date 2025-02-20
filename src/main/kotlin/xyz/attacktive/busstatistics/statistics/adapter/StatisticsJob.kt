package xyz.attacktive.busstatistics.statistics.adapter

import java.time.LocalDateTime
import kotlin.math.absoluteValue
import kotlinx.datetime.toJavaLocalDateTime
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.stereotype.Component
import xyz.attacktive.busstatistics.configuration.AppConfigurationProperties
import xyz.attacktive.busstatistics.statistics.adapter.table.ActualArrivalTable
import xyz.attacktive.busstatistics.statistics.adapter.table.BusArrivalTable
import xyz.attacktive.busstatistics.statistics.adapter.table.BusPositionTable
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalRequest
import xyz.attacktive.busstatistics.statistics.domain.BusPositionRequest
import xyz.attacktive.busstatistics.statistics.domain.BusRouteRequest

@Component
class StatisticsJob(private val appConfigurationProperties: AppConfigurationProperties, private val statisticsService: StatisticsService): Job {
	override fun execute(context: JobExecutionContext?) {
		val serviceKey = appConfigurationProperties.serviceKey
		val busRouteId = appConfigurationProperties.busRouteId
		val stationId = appConfigurationProperties.stId

		val route = statisticsService.getBusRoute(BusRouteRequest(serviceKey, busRouteId))

		val stations = route.stations
		val station = stations.find { it.station == stationId }
		if (station == null) {
			throw IllegalArgumentException("Station ID (or number) $stationId can't be found.")
		}

		val (beginningStationOrdinal, endingStationOrdinal) = stations.map { it.seq }
			.sorted()
			.let { it.first().toInt() to it.last().toInt() }

		val busPositions = statisticsService.getBusPositions(BusPositionRequest(serviceKey, busRouteId, beginningStationOrdinal, endingStationOrdinal))
		val stationSequence = station.seq.toInt()
		val busArrivals = statisticsService.getBusArrivals(BusArrivalRequest(serviceKey, stationId, busRouteId, stationSequence))

		transaction {
			busPositions.forEach { BusPositionTable.insertPosition(busRouteId, it) }
			busArrivals.forEach { BusArrivalTable.insertArrival(busRouteId, stationId, stationSequence, it) }
		}

		val insertedIds = transaction {
			val newBusses = BusArrivalTable
				.select(BusArrivalTable.vehId1, BusArrivalTable.exps1, BusArrivalTable.mkTm)
				.where {
					BusArrivalTable.vehId1 notInSubQuery ActualArrivalTable.select(ActualArrivalTable.vehicleId) and
						(BusArrivalTable.mkTm greater LocalDateTime.now().minusHours(1))
				}

			newBusses.map {
				val remainingSeconds = it[BusArrivalTable.exps1].toLong()
				val retrievalDateTime = it[BusArrivalTable.mkTm]

				val estimatedArrivalDateTime = retrievalDateTime.plusSeconds(remainingSeconds)

				val insertStatement = ActualArrivalTable.insertActualArrival(it[BusArrivalTable.vehId1], estimatedArrivalDateTime, retrievalDateTime)

				insertStatement[ActualArrivalTable.id].absoluteValue
			}
		}

		for (busArrival in busArrivals) {
			val vehicleId = busArrival.vehId1
			val busPosition = busPositions.find { it.vehId == vehicleId }
			if (busPosition == null) {
				throw RuntimeException("The first arriving vehicle $vehicleId does not exist.")
			}

			transaction {
				val record = ActualArrivalTable
					.select(ActualArrivalTable.id, ActualArrivalTable.vehicleId, ActualArrivalTable.estimatedAt)
					.where { ActualArrivalTable.id notInList insertedIds }
					.find { it[ActualArrivalTable.vehicleId] == vehicleId }

				if (record != null) {
					val estimatedArrivalDateTime = busArrival.mkTmDateTime
						.toJavaLocalDateTime()
						.plusSeconds(busArrival.exps1.toLong())

					ActualArrivalTable.updateActualArrival(record[ActualArrivalTable.id], estimatedArrivalDateTime, record[ActualArrivalTable.estimatedAt])
				}
			}
		}
	}
}
