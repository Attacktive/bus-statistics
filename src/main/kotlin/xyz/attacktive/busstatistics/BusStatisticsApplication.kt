package xyz.attacktive.busstatistics

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import xyz.attacktive.busstatistics.configuration.AppConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties(AppConfigurationProperties::class)
class BusStatisticsApplication

fun main(args: Array<String>) {
	runApplication<BusStatisticsApplication>(*args)
}
