package xyz.attacktive.busstatistics.statistics.port

import xyz.attacktive.busstatistics.statistics.domain.BusArrivalRequest
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalResponse
import xyz.attacktive.busstatistics.statistics.domain.BusPositionRequest
import xyz.attacktive.busstatistics.statistics.domain.BusPositionResponse

interface StatisticsUseCase {
	fun getBusPositions(busPositionRequest: BusPositionRequest): List<BusPositionResponse>

	fun getBusArrivals(busArrivalRequest: BusArrivalRequest): BusArrivalResponse?
}
