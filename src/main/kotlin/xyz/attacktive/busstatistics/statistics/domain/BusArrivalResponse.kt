package xyz.attacktive.busstatistics.statistics.domain

import kotlin.time.DurationUnit
import kotlin.time.toDuration
import kotlinx.serialization.Serializable
import xyz.attacktive.busstatistics.configuration.DateTimeSerializer

@Serializable(with = DateTimeSerializer::class)
data class BusArrivalResponse(
	/**
	 * 정류소 고유 ID
	 */
	val stId: String,

	/**
	 * 정류소명
	 */
	val stNm: String,

	/**
	 * 정류소 번호
	 */
	val arsId: String,

	/**
	 * 노선명 (안내용 - 마을버스 제외)
	 */
	val busRouteAbrv: String,

	/**
	 * 노선ID
	 */
	val busRouteId: String,

	/**
	 * 노선명 (DB관리용)
	 */
	val rtNm: String,

	/**
	 * 첫차시간
	 */
	@Transient
	val firstTm: String,

	/**
	 * 막차시간
	 */
	@Transient
	val lastTm: String,

	/**
	 * 배차간격 (분)
	 */
	val term: String,

	/**
	 * 노선유형 (1:공항, 2:마을, 3:간선, 4:지선, 5:순환, 6:광역, 7:인천, 8:경기, 9:폐지, 0:공용)
	 */
	val routeType: String,

	/**
	 * 막차운행여부 (N:막차, Y:막차아님)
	 */
	val nextBus: String,

	/**
	 * 요청정류소순번
	 */
	val staOrd: String,

	/**
	 * 방향
	 */
	val dir: String,

	/**
	 * 제공시각
	 */
	@Transient
	val mkTm: String,

	/**
	 * 첫번째도착예정버스ID
	 */
	val vehId1: String,

	/**
	 * 첫번째도착예정차량번호
	 */
	val plainNo1: String,

	/**
	 * 첫번째도착예정버스의 현재구간 순번
	 */
	val sectOrd1: String,

	/**
	 * 첫번째도착예정버스의 최종 정류소명
	 */
	val stationNm1: String,

	/**
	 * 첫번째도착예정버스의 여행시간 (분)
	 */
	val traTime1: String,

	/**
	 * 첫번째도착예정버스의 여행속도 (Km/h)
	 */
	val traSpd1: String,

	/**
	 * 첫번째도착예정버스의 최종 정류소 도착출발여부 (0:운행중, 1:도착)
	 */
	val isArrive1: String,

	/**
	 * 첫번째도착예정버스의 최종 보고 시간
	 */
	val repTm1: String?,

	/**
	 * 첫번째도착예정버스의 막차여부 (0:막차아님, 1:막차)
	 */
	val isLast1: String,

	/**
	 * 첫번째도착예정버스의 차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
	 */
	val busType1: String,

	/**
	 * 첫번째 도착예정 버스의 이동평균 보정계수
	 */
	val avgCf1: String,

	/**
	 * 첫번째 도착예정 버스의 지수평활 보정계수
	 */
	val expCf1: String,

	/**
	 * 첫번째 도착예정 버스의 기타1평균 보정계수
	 */
	val kalCf1: String,

	/**
	 * 첫번째 도착예정 버스의 기타2평균 보정계수
	 */
	val neuCf1: String,

	/**
	 * 첫번째 도착예정 버스의 지수평활 도착예정시간(초)
	 */
	val exps1: String,

	/**
	 * 첫번째 도착예정 버스의 기타1 도착예정시간(초)
	 */
	val kals1: String,

	/**
	 * 첫번째 도착예정 버스의 기타2 도착예정시간(초)
	 */
	val neus1: String,

	/**
	 * 첫번째 도착예정 버스의 재차 구분값 - reride_Num1의 구분값(0: 데이터없음, 4:혼잡도)
	 */
	val rerdie_Div1: String,

	/**
	 * 첫번째 도착예정 버스의 재차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
	 */
	val reride_Num1: String,

	/**
	 * 첫번째 도착예정 버스의 뒷차 구분값 - brdrde_Num1의 구분값(0: 데이터없음, 4:혼잡도)
	 */
	val brerde_Div1: String,

	/**
	 * 첫번째 도착예정 버스의 뒷차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
	 */
	val brdrde_Num1: String,

	/**
	 * 첫번째 도착예정 버스의 만차여부
	 */
	val full1: String,

	/**
	 * 첫번째 도착예정 버스의 다음정류소 ID
	 */
	val nstnId1: String,

	/**
	 * 첫번째 도착예정 버스의다음 정류소 순번
	 */
	val nstnOrd1: String,

	/**
	 * 첫번째 도착예정 버스의 다음 정류소 예정여행시간
	 */
	val nstnSpd1: String,

	/**
	 * 첫번째 도착예정 버스의 다음 정류소 예정여행시간
	 */
	val nstnSec1: String,

	/**
	 * 첫번째 도착예정 버스의 1번째 주요정류소 ID
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmainStnid1: String,

	/**
	 * 첫번째 도착예정 버스의 1번째 주요정류소 순번
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmainOrd1: String,

	/**
	 * 첫번째 도착예정 버스의 1번째 주요정류소 예정여행시간
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmainSec1: String,

	/**
	 * 첫번째 도착예정 버스의 2번째 주요정류소 ID
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain2Stnid1: String,

	/**
	 * 첫번째 도착예정 버스의 2번째 주요정류소 순번
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain2Ord1: String,

	/**
	 * 첫번째 도착예정 버스의 2번째 주요정류소 예정여행시간
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val namin2Sec1: String,

	/**
	 * 첫번째 도착예정 버스의 3번째 주요정류소 ID
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain3Stnid1: String,

	/**
	 * 첫번째 도착예정 버스의 3번째 주요정류소 순번
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain3Ord1: String,

	/**
	 * 첫번째 도착예정 버스의 3번째 주요정류소 예정여행시간
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain3Sec1: String,

	/**
	 * 첫번째 도착예정 버스의 종점 도착예정시간(초)
	 */
	val goal1: String,

	/**
	 * 두번째 도착예정버스ID
	 */
	val vehId2: String,

	/**
	 * 두번째도착예정차량번호
	 */
	val plainNo2: String,

	/**
	 * 두번째도착예정버스의 현재구간 순번
	 */
	val sectOrd2: String,

	/**
	 * 두번째도착예정버스의 최종 정류소명
	 */
	val stationNm2: String,

	/**
	 * 두번째도착예정버스의 여행시간
	 */
	val traTime2: String,

	/**
	 * 두번째도착예정버스의 여행속도
	 */
	val traSpd2: String,

	/**
	 * 두번째도착예정버스의 최종 정류소 도착출발여부 (0:운행중, 1:도착)
	 */
	val isArrive2: String,

	/**
	 * 두번째도착예정버스의 최종 보고 시간
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val repTm2: String?,

	/**
	 * 두번째도착예정버스의 막차여부 (0:막차아님, 1:막차)
	 */
	val isLast2: String,

	/**
	 * 두번째도착예정버스의 차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
	 */
	val busType2: String,

	/**
	 * 두번째 도착예정 버스의 이동평균 보정계수
	 */
	val avgCf2: String,

	/**
	 * 두번째 도착예정 버스의 지수평활 보정계수
	 */
	val expCf2: String,

	/**
	 * 두번째 도착예정 버스의 기타1평균 보정계수
	 */
	val kalCf2: String,

	/**
	 * 두번째 도착예정 버스의 기타2평균 보정계수
	 */
	val neuCf2: String,

	/**
	 * 두번째 도착예정 버스의 지수평활 도착예정시간(초)
	 */
	val exps2: String,

	/**
	 * 두번째 도착예정 버스의 기타1 도착예정시간(초)
	 */
	val kals2: String,

	/**
	 * 두번째 도착예정 버스의 기타2 도착예정시간(초)
	 */
	val neus2: String,

	/**
	 * 두번째 도착예정 버스의 재차 구분값 - reride_Num2의 구분값(0: 데이터없음, 4:혼잡도)
	 */
	val rerdie_Div2: String,

	/**
	 * 두번째 도착예정 버스의 재차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
	 */
	val reride_Num2: String,

	/**
	 * 두번째 도착예정 버스의 뒷차 구분값 - brdrde_Num2의 구분값(0: 데이터없음, 4:혼잡도)
	 */
	val brerde_Div2: String,

	/**
	 * 두번째 도착예정 버스의 뒷차 인원 혼잡도(0: 데이터없음, 3: 여유, 4: 보통, 5: 혼잡)
	 */
	val brdrde_Num2: String,

	/**
	 * 두번째 도착예정 버스의 만차여부
	 */
	val full2: String,

	/**
	 * 두번째 도착예정 버스의 다음정류소 ID
	 */
	val nstnId2: String,

	/**
	 * 두번째 도착예정 버스의다음 정류소 순번
	 */
	val nstnOrd2: String,

	/**
	 * 두번째 도착예정 버스의 다음 정류소 예정여행시간
	 */
	val nstnSpd2: String,

	/**
	 * 두번째 도착예정 버스의 다음 정류소 예정여행시간
	 */
	val nstnSec2: String,

	/**
	 * 두번째 도착예정 버스의 1번째 주요정류소 ID
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmainStnid2: String,

	/**
	 * 두번째 도착예정 버스의 1번째 주요정류소 순번
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmainOrd2: String,

	/**
	 * 두번째 도착예정 버스의 1번째 주요정류소 예정여행시간
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmainSec2: String,

	/**
	 * 두번째 도착예정 버스의 2번째 주요정류소 ID
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain2Stnid2: String,

	/**
	 * 두번째 도착예정 버스의 2번째 주요정류소 순번
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain2Ord2: String,

	/**
	 * 두번째 도착예정 버스의 2번째 주요정류소 예정여행시간
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val namin2Sec2: String,

	/**
	 * 두번째 도착예정 버스의 3번째 주요정류소 ID
	 */
	val nmain3Stnid2: String,

	/**
	 * 두번째 도착예정 버스의 3번째 주요정류소 순번
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain3Ord2: String,

	/**
	 * 두번째 도착예정 버스의 3번째 주요정류소 예정여행시간
	 *
	 * ⚠: appears to be always `"0"`
	 */
	val nmain3Sec2: String,

	/**
	 * 두번째 도착예정 버스의 종점 도착예정시간(초)
	 */
	val goal2: String,

	/**
	 * 첫번째 도착예정 버스의 도착정보메시지
	 */
	val arrmsg1: String,

	/**
	 * 두번째 도착예정 버스의 도착정보메시지
	 */
	val arrmsg2: String,

	/**
	 * `"00"`
	 */
	val deTourAt: String
) {
	companion object {
		fun digitOnlyRepresentationToLocalDateTime(literal: String?) = literal?.let { DateTimeSerializer.digitOnlyFormatter.parse(it) }

		fun rfc3339LikeRepresentationToLocalDateTime(literal: String?) = literal?.let { DateTimeSerializer.rfc3339LikeFormatter.parse(it) }
	}

	val firstTmFormatted = digitOnlyRepresentationToLocalDateTime(firstTm)
	val lastTmFormatted = digitOnlyRepresentationToLocalDateTime(lastTm)
	val mkTmFormatted = rfc3339LikeRepresentationToLocalDateTime(mkTm)

	val arrival1Eta = traTime1.toInt().toDuration(DurationUnit.SECONDS).toString()
	val arrival1RemainingStops = nstnOrd1.toInt()

	val arrival2Eta = traTime2.toInt().toDuration(DurationUnit.SECONDS).toString()
	val arrival2RemainingStops = nstnOrd2.toInt()
}
