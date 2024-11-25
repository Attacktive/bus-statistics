package xyz.attacktive.busstatistics.configuration

import jakarta.annotation.PostConstruct
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "app")
data class AppConfigurationProperties @ConstructorBinding constructor(val serviceKey: String) {
	@PostConstruct
	fun validateServiceKey() {
		if (serviceKey.isEmpty()) {
			throw IllegalArgumentException("The service key must be provided via the environment variable: SERVICE_KEY")
		}
	}
}
