plugins {
	kotlin("jvm") version "2.1.20"
	kotlin("plugin.spring") version "2.1.10"
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "xyz.attacktive"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot", "spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot", "spring-boot-starter-web")
	implementation("org.springframework.boot", "spring-boot-starter-quartz")
	implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")
	implementation("org.jetbrains.kotlin", "kotlin-reflect")
	implementation("org.jetbrains.exposed", "exposed-core", "0.59.0")
	implementation("org.jetbrains.exposed", "exposed-dao", "0.59.0")
	implementation("org.jetbrains.exposed", "exposed-java-time", "0.59.0")
	implementation("org.jetbrains.exposed", "exposed-jdbc", "0.59.0")
	implementation("org.jetbrains.exposed", "exposed-spring-boot-starter", "0.59.0")
	implementation("org.jetbrains.kotlinx", "kotlinx-datetime-jvm", "0.6.1")
	implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json-jvm", "1.8.0")
	runtimeOnly("org.postgresql", "postgresql")
	implementation("io.github.oshai", "kotlin-logging-jvm", "7.0.3")
	annotationProcessor("org.springframework.boot", "spring-boot-configuration-processor")
	testImplementation("org.springframework.boot", "spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin", "kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform", "junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
