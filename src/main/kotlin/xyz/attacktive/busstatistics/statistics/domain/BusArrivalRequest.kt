package xyz.attacktive.busstatistics.statistics.domain

import org.springframework.web.util.UriBuilder

data class BusArrivalRequest(private val serviceKey: String, private val stId: String, private val busRouteId: String, private val ord: Int): ApiRequest {
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
