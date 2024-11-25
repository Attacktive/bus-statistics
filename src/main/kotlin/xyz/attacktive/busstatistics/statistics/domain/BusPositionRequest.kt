package xyz.attacktive.busstatistics.statistics.domain

import org.springframework.web.util.UriBuilder

data class BusPositionRequest(private val serviceKey: String, private val busRouteId: String, private val startOrd: Int, private val endOrd: Int): ApiRequest {
	override fun serviceKey(): String {
		return serviceKey
	}

	override fun addQueryParameters(uriBuilder: UriBuilder) = uriBuilder
		.queryParam("resultType", resultType())
		.queryParam("serviceKey", serviceKey)
		.queryParam("busRouteId", busRouteId)
		.queryParam("startOrd", startOrd)
		.queryParam("endOrd", endOrd)
}
