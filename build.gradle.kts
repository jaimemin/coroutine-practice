plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com.tistory.jaimemin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 코루틴 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}