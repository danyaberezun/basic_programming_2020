plugins {
    application
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
}

application {
    mainClassName = "me.FibonacciKt"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

tasks.test {
    useJUnitPlatform()
}
