package xyz.attacktive.busstatistics.job

import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.stereotype.Component
import xyz.attacktive.busstatistics.statistics.adapter.StatisticsService

@Component
class StatisticsJob(private val statisticsService: StatisticsService): Job {
	override fun execute(context: JobExecutionContext?) {

	}
}
