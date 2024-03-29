plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "misuy"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest{
        attributes["Main-Class"] = "MainKt"
    }
    configurations["compileClasspath"].forEach { file: File -> from(zipTree(file.absoluteFile)) }

}