import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.5" apply true
	id("io.spring.dependency-management") version "1.1.3" apply true
	kotlin("jvm") version "1.8.22" apply true
	kotlin("plugin.spring") version "1.8.22" apply true
	kotlin("plugin.jpa") version "1.8.22" apply true
	kotlin("kapt") version "1.8.22" apply true
}

allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	val querydslVersion = "5.0.0"
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "org.jetbrains.kotlin.kapt")

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		runtimeOnly("com.h2database:h2")
		testImplementation("org.springframework.boot:spring-boot-starter-test")

		//querydsl
		implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
		kapt("com.querydsl:querydsl-apt:${querydslVersion}:jakarta")
	}
}
