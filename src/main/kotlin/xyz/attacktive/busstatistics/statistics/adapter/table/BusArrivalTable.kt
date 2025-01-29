package xyz.attacktive.busstatistics.statistics.adapter.table

import java.time.LocalDateTime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.javatime.datetime
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalResponse

object BusArrivalTable: Table("bus_arrival") {
	val id = long("id").autoIncrement()
	val busRouteId = varchar("bus_route_id", 50)
	val stationId = varchar("station_id", 50)
	val stationSequence = integer("station_sequence")
	val stId = varchar("st_id", 50)
	val stNm = varchar("st_nm", 100)
	val arsId = varchar("ars_id", 50)
	val busRouteAbrv = varchar("bus_route_abrv", 100)
	val rtNm = varchar("rt_nm", 100)
	val term = varchar("term", 10)
	val routeType = varchar("route_type", 1)
	val nextBus = varchar("next_bus", 1)
	val staOrd = varchar("sta_ord", 10)
	val dir = varchar("dir", 100)
	val mkTm = varchar("mk_tm", 50)
	val vehId1 = varchar("veh_id1", 50)
	val plainNo1 = varchar("plain_no1", 50)
	val sectOrd1 = varchar("sect_ord1", 10)
	val stationNm1 = varchar("station_nm1", 100)
	val traTime1 = varchar("tra_time1", 10)
	val traSpd1 = varchar("tra_spd1", 10)
	val isArrive1 = varchar("is_arrive1", 1)
	val repTm1 = varchar("rep_tm1", 50).nullable()
	val isLast1 = varchar("is_last1", 1)
	val busType1 = varchar("bus_type1", 1)
	val avgCf1 = varchar("avg_cf1", 10)
	val expCf1 = varchar("exp_cf1", 10)
	val kalCf1 = varchar("kal_cf1", 10)
	val neuCf1 = varchar("neu_cf1", 10)
	val exps1 = varchar("exps1", 10)
	val kals1 = varchar("kals1", 10)
	val neus1 = varchar("neus1", 10)
	val rerdieDiv1 = varchar("rerdie_div1", 1)
	val rerideNum1 = varchar("reride_num1", 1)
	val brerdeDiv1 = varchar("brerde_div1", 1)
	val brdrdeNum1 = varchar("brdrde_num1", 1)
	val full1 = varchar("full1", 1)
	val nstnId1 = varchar("nstn_id1", 50)
	val nstnOrd1 = varchar("nstn_ord1", 10)
	val nstnSec1 = varchar("nstn_sec1", 10)
	val nmainStnid1 = varchar("nmain_stnid1", 50)
	val nmainOrd1 = varchar("nmain_ord1", 10)
	val nmainSec1 = varchar("nmain_sec1", 10)
	val nmain2Stnid1 = varchar("nmain2_stnid1", 50)
	val nmain2Ord1 = varchar("nmain2_ord1", 10)
	val nmain2Sec1 = varchar("nmain2_sec1", 10)
	val vehId2 = varchar("veh_id2", 50)
	val plainNo2 = varchar("plain_no2", 50)
	val sectOrd2 = varchar("sect_ord2", 10)
	val stationNm2 = varchar("station_nm2", 100)
	val traTime2 = varchar("tra_time2", 10)
	val traSpd2 = varchar("tra_spd2", 10)
	val isArrive2 = varchar("is_arrive2", 1)
	val repTm2 = varchar("rep_tm2", 50).nullable()
	val isLast2 = varchar("is_last2", 1)
	val busType2 = varchar("bus_type2", 1)
	val avgCf2 = varchar("avg_cf2", 10)
	val expCf2 = varchar("exp_cf2", 10)
	val kalCf2 = varchar("kal_cf2", 10)
	val neuCf2 = varchar("neu_cf2", 10)
	val exps2 = varchar("exps2", 10)
	val kals2 = varchar("kals2", 10)
	val neus2 = varchar("neus2", 10)
	val rerdieDiv2 = varchar("rerdie_div2", 1)
	val rerideNum2 = varchar("reride_num2", 1)
	val brerdeDiv2 = varchar("brerde_div2", 1)
	val brdrdeNum2 = varchar("brdrde_num2", 1)
	val full2 = varchar("full2", 1)
	val nstnId2 = varchar("nstn_id2", 50)
	val nstnOrd2 = varchar("nstn_ord2", 10)
	val nstnSec2 = varchar("nstn_sec2", 10)
	val nmainStnid2 = varchar("nmain_stnid2", 50)
	val nmainOrd2 = varchar("nmain_ord2", 10)
	val nmainSec2 = varchar("nmain_sec2", 10)
	val nmain2Stnid2 = varchar("nmain2_stnid2", 50)
	val nmain2Ord2 = varchar("nmain2_ord2", 10)
	val nmain2Sec2 = varchar("nmain2_sec2", 10)
	val timestamp = datetime("timestamp")

	override val primaryKey = PrimaryKey(id)

	fun insertArrival(
		busRouteId: String,
		stationId: String,
		stationSequence: Int,
		arrival: BusArrivalResponse,
		timestamp: LocalDateTime = LocalDateTime.now()
	) {
		insert {
			it[this.busRouteId] = busRouteId
			it[this.stationId] = stationId
			it[this.stationSequence] = stationSequence
			it[stId] = arrival.stId
			it[stNm] = arrival.stNm
			it[arsId] = arrival.arsId
			it[busRouteAbrv] = arrival.busRouteAbrv
			it[rtNm] = arrival.rtNm
			it[term] = arrival.term
			it[routeType] = arrival.routeType
			it[nextBus] = arrival.nextBus
			it[staOrd] = arrival.staOrd
			it[dir] = arrival.dir
			it[mkTm] = arrival.mkTm
			it[vehId1] = arrival.vehId1
			it[plainNo1] = arrival.plainNo1
			it[sectOrd1] = arrival.sectOrd1
			it[stationNm1] = arrival.stationNm1
			it[traTime1] = arrival.traTime1
			it[traSpd1] = arrival.traSpd1
			it[isArrive1] = arrival.isArrive1
			it[repTm1] = arrival.repTm1
			it[isLast1] = arrival.isLast1
			it[busType1] = arrival.busType1
			it[avgCf1] = arrival.avgCf1
			it[expCf1] = arrival.expCf1
			it[kalCf1] = arrival.kalCf1
			it[neuCf1] = arrival.neuCf1
			it[exps1] = arrival.exps1
			it[kals1] = arrival.kals1
			it[neus1] = arrival.neus1
			it[rerdieDiv1] = arrival.rerdie_Div1
			it[rerideNum1] = arrival.reride_Num1
			it[brerdeDiv1] = arrival.brerde_Div1
			it[brdrdeNum1] = arrival.brdrde_Num1
			it[full1] = arrival.full1
			it[nstnId1] = arrival.nstnId1
			it[nstnOrd1] = arrival.nstnOrd1
			it[nstnSec1] = arrival.nstnSec1
			it[nmainStnid1] = arrival.nmainStnid1
			it[nmainOrd1] = arrival.nmainOrd1
			it[nmainSec1] = arrival.nmainSec1
			it[nmain2Stnid1] = arrival.nmain2Stnid1
			it[nmain2Ord1] = arrival.nmain2Ord1
			it[nmain2Sec1] = arrival.namin2Sec1
			it[vehId2] = arrival.vehId2
			it[plainNo2] = arrival.plainNo2
			it[sectOrd2] = arrival.sectOrd2
			it[stationNm2] = arrival.stationNm2
			it[traTime2] = arrival.traTime2
			it[traSpd2] = arrival.traSpd2
			it[isArrive2] = arrival.isArrive2
			it[repTm2] = arrival.repTm2
			it[isLast2] = arrival.isLast2
			it[busType2] = arrival.busType2
			it[avgCf2] = arrival.avgCf2
			it[expCf2] = arrival.expCf2
			it[kalCf2] = arrival.kalCf2
			it[neuCf2] = arrival.neuCf2
			it[exps2] = arrival.exps2
			it[kals2] = arrival.kals2
			it[neus2] = arrival.neus2
			it[rerdieDiv2] = arrival.rerdie_Div2
			it[rerideNum2] = arrival.reride_Num2
			it[brerdeDiv2] = arrival.brerde_Div2
			it[brdrdeNum2] = arrival.brdrde_Num2
			it[full2] = arrival.full2
			it[nstnId2] = arrival.nstnId2
			it[nstnOrd2] = arrival.nstnOrd2
			it[nstnSec2] = arrival.nstnSec2
			it[nmainStnid2] = arrival.nmainStnid2
			it[nmainOrd2] = arrival.nmainOrd2
			it[nmainSec2] = arrival.nmainSec2
			it[nmain2Stnid2] = arrival.nmain2Stnid2
			it[nmain2Ord2] = arrival.nmain2Ord2
			it[nmain2Sec2] = arrival.namin2Sec2
			it[this.timestamp] = timestamp
		}
	}
}
