package xyz.attacktive.busstatistics.statistics.domain

import org.springframework.web.util.UriBuilder

interface ApiRequest {
	fun resultType() = "json"

	fun serviceKey(): String

	fun addQueryParameters(uriBuilder: UriBuilder): UriBuilder
}
