plugins {
    kotlin("jvm") version "2.3.0"
    application
}

group = "org.iesra.revilofe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(11)
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.iesra.revilofe.MainKt")
}
