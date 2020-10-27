plugins {
    application
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
}

application {
    mainClassName = "vis.VisitorKt"
}

tasks.test {
    useJUnitPlatform()
}
