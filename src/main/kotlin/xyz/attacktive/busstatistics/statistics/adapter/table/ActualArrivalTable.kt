package xyz.attacktive.busstatistics.statistics.adapter.table

import java.time.LocalDateTime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.javatime.datetime

object ActualArrivalTable: Table("actual_arrival") {
	val id = long("id").autoIncrement()
	val vehicleId = varchar("vehicle_id", 50)
	val estimatedArrivalDateTime = datetime("estimated_arrival_date_time")
	val actualArrivalDateTime = datetime("actual_arrival_date_time").nullable()
	val estimatedAt = datetime("estimated_at")
	val arrivalRecordedAt = datetime("arrival_recorded_at").nullable()

	override val primaryKey = PrimaryKey(id)

	fun insertActualArrival(vehicleId: String, estimatedArrivalDateTime: LocalDateTime, actualArrivalDateTime: LocalDateTime? = null) {
		insert {
			it[ActualArrivalTable.vehicleId] = vehicleId
			it[ActualArrivalTable.estimatedArrivalDateTime] = estimatedArrivalDateTime
			it[ActualArrivalTable.actualArrivalDateTime] = actualArrivalDateTime

			it[estimatedAt] = LocalDateTime.now()
			if (actualArrivalDateTime != null) {
				it[arrivalRecordedAt] = LocalDateTime.now()
			}
		}
	}
}
