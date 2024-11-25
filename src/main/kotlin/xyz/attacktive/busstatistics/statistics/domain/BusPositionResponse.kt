package xyz.attacktive.busstatistics.statistics.domain

data class BusPositionResponse(
	/**
	 * 구간순번
	 */
	val sectOrd: String,

	/**
	 * 구간옵셋거리(Km)
	 */
	val sectDist: String,

	/**
	 * 정류소도착여부 (0:운행중, 1:도착)
	 */
	val stopFlag: String,

	/**
	 * 구간 ID
	 */
	val sectionId: String,

	/**
	 * 제공시간
	 */
	val dataTm: String,

	/**
	 * 맵매칭X좌표 (WGS84)
	 */
	val tmX: String,

	/**
	 * 맵매칭Y좌표 (WGS84)
	 */
	val tmY: String,

	/**
	 * 버스 ID
	 */
	val vehId: String,

	/**
	 * 차량번호
	 */
	val plainNo: String,

	/**
	 * 차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
	 */
	val busType: String,

	/**
	 * 최종정류장ID
	 */
	val lastStnId: String,

	/**
	 * 맵매칭X좌표 (GRS80)
	 */
	val posX: String,

	/**
	 * 맵매칭Y좌표 (GRS80)
	 */
	val posY: String,

	/**
	 * 노선 ID
	 */
	val routeId: String,

	/**
	 * 혼잡도 (3 : 여유, 4 : 보통, 5 : 혼잡, 6 : 매우혼잡)
	 */
	val congetion: String,

	/**
	 * 만차여부(0 : 만차아님, 1: 만차)
	 */
	val isFullFlag: String
)
