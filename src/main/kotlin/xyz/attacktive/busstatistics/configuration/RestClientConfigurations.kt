package xyz.attacktive.busstatistics.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfigurations {
	@Bean
	fun restClient() = RestClient.create("http://ws.bus.go.kr/api/rest")
}
