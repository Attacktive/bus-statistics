package xyz.attacktive.busstatistics.statistics.adapter

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import xyz.attacktive.busstatistics.statistics.domain.BusRouteRequest
import xyz.attacktive.busstatistics.statistics.domain.BusRouteResponse

class StatisticsServiceTest {
	@Test
	fun `should build correct URI for bus route request`() {
		val request = BusRouteRequest("test-key", "route123")

		assertEquals("test-key", request.serviceKey())
		assertEquals("json", request.resultType())
	}

	@Test
	fun `should create bus route response correctly`() {
		val stations = listOf(
			BusRouteResponse.BusStation(
				busRouteId = "123",
				busRouteNm = "Test Route",
				busRouteAbrv = "TR",
				seq = "1",
				section = "sec1",
				station = "st1",
				arsId = "ars1",
				stationNm = "Test Station",
				gpsX = "127.0",
				gpsY = "37.0",
				posX = "200000.0",
				posY = "450000.0",
				fullSectDist = "1000",
				direction = "up",
				stationNo = "1001",
				routeType = "3",
				beginTm = "0500",
				lastTm = "2300",
				trnstnid = "0",
				sectSpd = "30",
				transYn = "N"
			)
		)

		val response = BusRouteResponse(stations)

		assertEquals(1, response.stations.size)
		assertEquals("123", response.id)
		assertEquals("Test Route", response.name)
	}
}
