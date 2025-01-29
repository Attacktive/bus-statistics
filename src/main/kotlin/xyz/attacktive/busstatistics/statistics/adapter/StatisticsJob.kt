package xyz.attacktive.busstatistics.statistics.adapter

import java.time.LocalDateTime
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.stereotype.Component
import xyz.attacktive.busstatistics.configuration.AppConfigurationProperties
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalRequest
import xyz.attacktive.busstatistics.statistics.adapter.table.BusArrivalTable
import xyz.attacktive.busstatistics.statistics.domain.BusPositionRequest
import xyz.attacktive.busstatistics.statistics.adapter.table.BusPositionTable
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
		val stationSequence = stations.last().seq.toInt()
		val busArrivals = statisticsService.getBusArrivals(BusArrivalRequest(serviceKey, stationId, busRouteId, stationSequence))

		val now = LocalDateTime.now()

		transaction {
			SchemaUtils.create(BusPositionTable, BusArrivalTable)

			busPositions.forEach { BusPositionTable.insertPosition(busRouteId, it, now) }
			busArrivals.forEach { BusArrivalTable.insertArrival(busRouteId, stationId, stationSequence, it, now) }
		}
	}
}
