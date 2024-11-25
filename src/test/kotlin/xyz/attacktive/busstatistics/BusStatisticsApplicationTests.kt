package xyz.attacktive.busstatistics

import kotlin.test.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import xyz.attacktive.busstatistics.statistics.adapter.StatisticsController
import xyz.attacktive.busstatistics.statistics.adapter.StatisticsService

@SpringBootTest
class BusStatisticsApplicationTests(private val statisticsController: StatisticsController, private val statisticsService: StatisticsService) {
	@Test
	fun contextLoads() {
		assertNotNull(statisticsController)
		assertNotNull(statisticsService)
	}
}
