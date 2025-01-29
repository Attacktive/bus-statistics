package xyz.attacktive.busstatistics.configuration

import org.quartz.CronScheduleBuilder
import org.quartz.JobBuilder
import org.quartz.JobKey
import org.quartz.Scheduler
import org.quartz.TriggerBuilder
import org.quartz.TriggerKey
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.quartz.SchedulerFactoryBean
import xyz.attacktive.busstatistics.statistics.adapter.StatisticsJob

@Configuration
class SchedulingConfigurations {
	@Bean
	fun scheduler(schedulerFactoryBean: SchedulerFactoryBean, appConfigurationProperties: AppConfigurationProperties): Scheduler {
		val jobDetail = JobBuilder.newJob()
			.ofType(StatisticsJob::class.java)
			.storeDurably()
			.withIdentity(JobKey.jobKey("Qrtz_Job_Detail"))
			.withDescription("Invoke Sample Job service...")
			.build()

		val trigger = TriggerBuilder.newTrigger()
			.forJob(jobDetail)
			.withIdentity(TriggerKey.triggerKey("Qrtz_Trigger_Detail"))
			.withDescription("Sample Trigger")
			.withSchedule(CronScheduleBuilder.cronSchedule(appConfigurationProperties.scheduleCronExpression))
			.build()

		schedulerFactoryBean.scheduler.scheduleJob(jobDetail, trigger)

		return schedulerFactoryBean.scheduler
	}
}
