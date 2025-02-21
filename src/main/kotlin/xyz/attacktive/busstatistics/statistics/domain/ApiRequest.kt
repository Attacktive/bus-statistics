package xyz.attacktive.busstatistics.statistics.domain

import java.net.URI
import org.springframework.web.util.UriBuilder

interface ApiRequest {
	fun resultType() = "json"

	fun serviceKey(): String

	fun buildUri(uriBuilder: UriBuilder): URI
}
