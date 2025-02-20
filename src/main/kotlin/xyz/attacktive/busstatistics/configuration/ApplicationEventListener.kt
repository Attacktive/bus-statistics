package xyz.attacktive.busstatistics.configuration

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import xyz.attacktive.busstatistics.statistics.adapter.table.ActualArrivalTable
import xyz.attacktive.busstatistics.statistics.adapter.table.BusArrivalTable
import xyz.attacktive.busstatistics.statistics.adapter.table.BusPositionTable

@Component
class ApplicationEventListener {
	@EventListener(ApplicationReadyEvent::class)
	fun onApplicationReady() {
		transaction {
			SchemaUtils.create(BusPositionTable, BusArrivalTable, ActualArrivalTable)
		}
	}
}
