package xyz.attacktive.busstatistics.statistics.adapter

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import xyz.attacktive.busstatistics.configuration.AppConfigurationProperties
import xyz.attacktive.busstatistics.statistics.domain.BusArrivalRequest
import xyz.attacktive.busstatistics.statistics.domain.BusPositionRequest
import xyz.attacktive.busstatistics.statistics.port.StatisticsUseCase

@Controller
@RequestMapping("busses")
class StatisticsController(private val appConfigurationProperties: AppConfigurationProperties, private val statisticsUseCase: StatisticsUseCase) {
	@GetMapping("positions")
	fun getBusPositions(@RequestParam busRouteId: String, @RequestParam startOrd: Int = 1, @RequestParam endOrd: Int = Int.MAX_VALUE, model: Model): String {
		val busPositionRequest = BusPositionRequest(
			serviceKey = appConfigurationProperties.serviceKey,
			busRouteId = busRouteId,
			startOrd = startOrd,
			endOrd = endOrd
		)

		val busPositions = statisticsUseCase.getBusPositions(busPositionRequest)
		model.addAttribute("busPositions", busPositions)

		return "bus-positions"
	}

	@GetMapping("arrivals")
	fun getBusArrivals(@RequestParam stId: String, @RequestParam busRouteId: String, @RequestParam ord: Int, model: Model): String {
		val busArrivalRequest = BusArrivalRequest(
			serviceKey = appConfigurationProperties.serviceKey,
			stId = stId,
			busRouteId = busRouteId,
			ord = ord
		)

		val busArrivals = statisticsUseCase.getBusArrivals(busArrivalRequest)
		model.addAttribute("busArrivals", busArrivals)

		return "bus-arrivals"
	}
}
