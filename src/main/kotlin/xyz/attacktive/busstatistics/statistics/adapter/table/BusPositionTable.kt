package xyz.attacktive.busstatistics.statistics.adapter.table

import java.time.LocalDateTime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.javatime.datetime
import xyz.attacktive.busstatistics.statistics.domain.BusPositionResponse

object BusPositionTable: Table("bus_position") {
	val id = long("id").autoIncrement()
	val busRouteId = varchar("bus_route_id", 50)
	val timestamp = datetime("timestamp")
	val sectOrd = varchar("sect_ord", 50)
	val sectDist = varchar("sect_dist", 50)
	val stopFlag = varchar("stop_flag", 1)
	val sectionId = varchar("section_id", 50)
	val dataTm = varchar("data_tm", 50)
	val tmX = varchar("tm_x", 50)
	val tmY = varchar("tm_y", 50)
	val vehId = varchar("veh_id", 50)
	val plainNo = varchar("plain_no", 50)
	val busType = varchar("bus_type", 1)
	val lastStnId = varchar("last_stn_id", 50)
	val posX = varchar("pos_x", 50)
	val posY = varchar("pos_y", 50)
	val routeId = varchar("route_id", 50)
	val congetion = varchar("congetion", 1)
	val isFullFlag = varchar("is_full_flag", 1)

	override val primaryKey = PrimaryKey(id)

	fun insertPosition(busRouteId: String, position: BusPositionResponse, timestamp: LocalDateTime = LocalDateTime.now()) {
		insert {
			it[this.busRouteId] = busRouteId
			it[this.timestamp] = timestamp
			it[sectOrd] = position.sectOrd
			it[sectDist] = position.sectDist
			it[stopFlag] = position.stopFlag
			it[sectionId] = position.sectionId
			it[dataTm] = position.dataTm
			it[tmX] = position.tmX
			it[tmY] = position.tmY
			it[vehId] = position.vehId
			it[plainNo] = position.plainNo
			it[busType] = position.busType
			it[lastStnId] = position.lastStnId
			it[posX] = position.posX
			it[posY] = position.posY
			it[routeId] = position.routeId
			it[congetion] = position.congetion
			it[isFullFlag] = position.isFullFlag
		}
	}
}
