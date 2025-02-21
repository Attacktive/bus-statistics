package xyz.attacktive.busstatistics.statistics.domain

import org.springframework.web.util.UriBuilder

/**
 * [노선별경유정류소목록조회](http://api.bus.go.kr/contents/sub02/getStaionByRoute.html)
 * @property serviceKey 발급받은 키 값
 * @property busRouteId 노선 ID
 */
data class BusRouteRequest(private val serviceKey: String, private val busRouteId: String): ApiRequest {
	override fun serviceKey() = serviceKey

	override fun buildUri(uriBuilder: UriBuilder) = uriBuilder.path("/busRouteInfo/getStaionByRoute")
		.queryParam("resultType", resultType())
		.queryParam("serviceKey", serviceKey)
		.queryParam("busRouteId", busRouteId)
		.build()
}
