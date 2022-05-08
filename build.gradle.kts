import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// モジュール全体のバージョン管理
//     Spring Boot Kotlin

plugins {
	id("org.springframework.boot") version "2.5.13"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.32"
	kotlin("plugin.spring") version "1.5.32"
}

// 全てのモジュールに対して適用するものを定義をする
allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	// 依存関係を取得することができる
	repositories {
		mavenCentral()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

// サブモジュールの共通
subprojects {
	apply {
		plugin("kotlin")
		plugin("io.spring.dependency-management")
		plugin("org.jetbrains.kotlin.jvm")
		plugin("org.jetbrains.kotlin.plugin.spring")
	}

	java.sourceCompatibility = JavaVersion.VERSION_11

	dependencies {
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	}
}

