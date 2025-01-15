package xyz.attacktive.busstatistics.statistics.domain

import org.springframework.web.util.UriBuilder

/**
 * [정류소노선별도착예정정보목록조회](http://api.bus.go.kr/contents/sub02/getArrInfoByRoute.html)
 * @property serviceKey 발급받은 키 값
 * @property stId 정류소 고유 ID
 * @property busRouteId 노선 ID
 * @property ord 정류소 순번
 */
data class BusArrivalRequest(
	private val serviceKey: String,
	private val stId: String,
	private val busRouteId: String,
	private val ord: Int
): ApiRequest {
	override fun serviceKey(): String {
		return serviceKey
	}

	override fun addQueryParameters(uriBuilder: UriBuilder) = uriBuilder
		.queryParam("resultType", resultType())
		.queryParam("serviceKey", serviceKey)
		.queryParam("stId", stId)
		.queryParam("busRouteId", busRouteId)
		.queryParam("ord", ord)
}
