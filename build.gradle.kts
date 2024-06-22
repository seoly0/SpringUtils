plugins {
    kotlin("jvm") version "1.9.22"
}

group = "me.seoly.spring"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    api("org.modelmapper:modelmapper:3.2.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}