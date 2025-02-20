package xyz.attacktive.busstatistics.statistics.domain

import org.springframework.web.util.UriBuilder

/**
 * [노선별특정정류소접근버스위치정보목록조회](http://api.bus.go.kr/contents/sub02/getBusPosByRouteSt.html)
 * @property serviceKey 발급받은 키 값
 * @property busRouteId 노선 ID
 * @property startOrd 시작 정류소 순번
 * @property endOrd 종료 정류소 순번
 */
data class BusPositionRequest(private val serviceKey: String, private val busRouteId: String, private val startOrd: Int, private val endOrd: Int): ApiRequest {
	override fun serviceKey() = serviceKey

	override fun addQueryParameters(uriBuilder: UriBuilder) = uriBuilder
		.queryParam("resultType", resultType())
		.queryParam("serviceKey", serviceKey)
		.queryParam("busRouteId", busRouteId)
		.queryParam("startOrd", startOrd)
		.queryParam("endOrd", endOrd)
}
