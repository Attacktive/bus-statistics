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
import xyz.attacktive.busstatistics.statistics.port.StatisticsUseCase

@Service
class StatisticsService(private val restClient: RestClient): StatisticsUseCase {
	companion object {
		private val logger = KotlinLogging.logger {}
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

	override fun getBusArrivals(busArrivalRequest: BusArrivalRequest): BusArrivalResponse? {
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

		return response.safeFirstItem
	}
}