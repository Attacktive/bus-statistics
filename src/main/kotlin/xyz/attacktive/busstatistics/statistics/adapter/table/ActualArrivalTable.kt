package xyz.attacktive.busstatistics.statistics.adapter.table

import java.time.LocalDateTime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.update

object ActualArrivalTable: Table("actual_arrival") {
	val id = long("id").autoIncrement()
	val vehicleId = varchar("vehicle_id", 50)
	val estimatedArrivalDateTime = datetime("estimated_arrival_date_time")
	val estimatedAt = datetime("estimated_at")
	val actualArrivalDateTime = datetime("actual_arrival_date_time").nullable()
	val arrivalRecordedAt = datetime("arrival_recorded_at").nullable()

	override val primaryKey = PrimaryKey(id)

	fun insertActualArrival(vehicleId: String, estimatedArrivalDateTime: LocalDateTime, retrievalDateTime: LocalDateTime): InsertStatement<Number> {
		return insert {
			it[ActualArrivalTable.vehicleId] = vehicleId
			it[ActualArrivalTable.estimatedArrivalDateTime] = estimatedArrivalDateTime
			it[estimatedAt] = retrievalDateTime
			it[actualArrivalDateTime] = estimatedArrivalDateTime
			it[arrivalRecordedAt] = retrievalDateTime
		}
	}

	fun updateActualArrival(id: Long, estimatedArrivalDateTime: LocalDateTime, retrievalDateTime: LocalDateTime): Int {
		return update({ ActualArrivalTable.id eq id}) {
			it[actualArrivalDateTime] = estimatedArrivalDateTime
			it[arrivalRecordedAt] = retrievalDateTime
		}
	}
}
