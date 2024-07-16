plugins {
    kotlin("jvm") version "1.9.10" // Updated Kotlin version
    id("org.springframework.boot") version "3.1.2" // Updated Spring Boot version
    id("io.spring.dependency-management") version "1.1.0" // Updated Dependency Management plugin version
    id("org.graalvm.buildtools.native") version "0.9.20" // Updated GraalVM Native Build Tools plugin version
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.15") // Updated SpringDoc version
    implementation("io.r2dbc:r2dbc-postgresql:0.8.8.RELEASE") // Use stable R2DBC PostgreSQL version
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
