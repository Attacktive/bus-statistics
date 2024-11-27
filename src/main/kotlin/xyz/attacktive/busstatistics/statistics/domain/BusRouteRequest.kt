package xyz.attacktive.busstatistics.statistics.domain

import org.springframework.web.util.UriBuilder

data class BusRouteRequest(private val serviceKey: String, private val busRouteId: String): ApiRequest {
	override fun serviceKey(): String {
		return serviceKey
	}

	override fun addQueryParameters(uriBuilder: UriBuilder) = uriBuilder
		.queryParam("resultType", resultType())
		.queryParam("serviceKey", serviceKey)
		.queryParam("busRouteId", busRouteId)
}
