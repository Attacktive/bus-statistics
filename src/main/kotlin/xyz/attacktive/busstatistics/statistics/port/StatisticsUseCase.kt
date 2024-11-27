package xyz.attacktive.busstatistics.statistics.port

import xyz.attacktive.busstatistics.statistics.domain.BusArrivalRequest
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalResponse
import xyz.attacktive.busstatistics.statistics.domain.BusPositionRequest
import xyz.attacktive.busstatistics.statistics.domain.BusPositionResponse
import xyz.attacktive.busstatistics.statistics.domain.BusRouteRequest
import xyz.attacktive.busstatistics.statistics.domain.BusRouteResponse

interface StatisticsUseCase {
	fun getBusRoute(busRouteRequest: BusRouteRequest): BusRouteResponse

	fun getBusPositions(busPositionRequest: BusPositionRequest): List<BusPositionResponse>

	fun getBusArrivals(busArrivalRequest: BusArrivalRequest): BusArrivalResponse?
}
