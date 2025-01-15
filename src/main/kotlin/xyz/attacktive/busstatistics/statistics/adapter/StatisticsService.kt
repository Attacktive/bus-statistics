package xyz.attacktive.busstatistics.statistics.adapter

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import xyz.attacktive.busstatistics.statistics.domain.ApiResponse
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalRequest
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalResponse
import xyz.attacktive.busstatistics.statistics.domain.BusPositionRequest
import xyz.attacktive.busstatistics.statistics.domain.BusPositionResponse
import xyz.attacktive.busstatistics.statistics.domain.BusRouteRequest
import xyz.attacktive.busstatistics.statistics.domain.BusRouteResponse
import xyz.attacktive.busstatistics.statistics.port.StatisticsUseCase

@Service
class StatisticsService(private val restClient: RestClient): StatisticsUseCase {
	companion object {
		private val logger = KotlinLogging.logger {}
	}

	override fun getBusRoute(busRouteRequest: BusRouteRequest): BusRouteResponse {
		logger.info { "trying to request /busRouteInfo/getStaionByRoute with $busRouteRequest" }

		val stations = (
			restClient.get()
				.uri {
					it.path("/busRouteInfo/getStaionByRoute")
					busRouteRequest.addQueryParameters(it)
					it.build()
				}
				.retrieve()
				.body(object: ParameterizedTypeReference<ApiResponse<BusRouteResponse.BusStation>>() {})
				?: throw IllegalStateException("Failed to get bus route")
			).safeItems

		return BusRouteResponse(stations)
	}

	override fun getBusPositions(busPositionRequest: BusPositionRequest): List<BusPositionResponse> {
		logger.info { "trying to request /buspos/getBusPosByRouteSt with $busPositionRequest" }

		return (
			restClient.get()
				.uri {
					it.path("/buspos/getBusPosByRouteSt")
					busPositionRequest.addQueryParameters(it)
					it.build()
				}
				.retrieve()
				.body(object: ParameterizedTypeReference<ApiResponse<BusPositionResponse>>() {})
				?: throw IllegalStateException("Failed to get bus positions")
			)
			.safeItems
	}

	override fun getBusArrivals(busArrivalRequest: BusArrivalRequest): List<BusArrivalResponse> {
		logger.info { "trying to request /arrive/getArrInfoByRoute with $busArrivalRequest" }

		val response = restClient.get()
			.uri {
				it.path("/arrive/getArrInfoByRoute")
				busArrivalRequest.addQueryParameters(it)
				it.build()
			}
			.retrieve()
			.body(object: ParameterizedTypeReference<ApiResponse<BusArrivalResponse>>() {})
			?: throw IllegalStateException("Failed to get bus arrivals")

		return response.safeItems
	}
}
