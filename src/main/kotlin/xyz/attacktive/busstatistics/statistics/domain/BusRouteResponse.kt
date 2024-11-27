package xyz.attacktive.busstatistics.statistics.domain

data class BusRouteResponse(val stations: List<BusStation>) {
	val id = stations.firstOrNull()?.busRouteId
	val name = stations.firstOrNull()?.busRouteNm

	data class BusStation(
		/**
		 * 노선 ID
		 */
		val busRouteId: String,

		/**
		 * 노선명 (DB관리용)
		 */
		val busRouteNm: String,

		/**
		 * 노선명 (안내용 - 마을버스 제외)
		 */
		val busRouteAbrv: String,

		/**
		 * 순번
		 */
		val seq: String,

		/**
		 * 구간 ID
		 */
		val section: String,

		/**
		 * 정류소 고유 ID
		 */
		val station: String,

		/**
		 * 정류소 고유번호
		 */
		val arsId: String,

		/**
		 * 정류소 이름
		 */
		val stationNm: String,

		/**
		 * X좌표 (WGS 84)
		 */
		val gpsX: String,

		/**
		 * Y좌표 (WGS 84)
		 */
		val gpsY: String,

		/**
		 * 좌표X (GRS80)
		 */
		val posX: String,

		/**
		 * 좌표Y (GRS80)
		 */
		val posY: String,

		/**
		 * 정류소간 거리
		 */
		val fullSectDist: String?,

		/**
		 * 진행방향
		 */
		val direction: String,

		/**
		 * 정류소 번호
		 */
		val stationNo: String,

		/**
		 * 노선 유형 (1:공항, 2:마을, 3:간선, 4:지선, 5:순환, 6:광역, 7:인천, 8:경기, 9:폐지, 0:공용)
		 */
		val routeType: String,

		/**
		 * 첫차 시간
		 */
		val beginTm: String,

		/**
		 * 막차 시간
		 */
		val lastTm: String,

		/**
		 * 회차지 정류소ID
		 */
		val trnstnid: String,

		/**
		 * 구간속도
		 */
		val sectSpd: String,

		/**
		 * 회차지 여부 (Y:회차, N:회차지아님)
		 */
		val transYn: String
	)
}
