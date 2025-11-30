package xyz.attacktive.busstatistics

import kotlin.test.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import xyz.attacktive.busstatistics.statistics.adapter.StatisticsController
import xyz.attacktive.busstatistics.statistics.adapter.StatisticsService

@SpringBootTest
@ActiveProfiles("test")
class BusStatisticsApplicationTests @Autowired constructor(private val statisticsController: StatisticsController, private val statisticsService: StatisticsService) {
	@Test
	fun contextLoads() {
		assertNotNull(statisticsController)
		assertNotNull(statisticsService)
	}
}
