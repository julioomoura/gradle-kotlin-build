plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    application
}

repositories {
    jcenter()
    mavenCentral()
}

group = "com.gradle.project"
version = "0.0.1-SNAPSHOT"
val mainClassName = "MainKt"
val apacheCommonsVersion = "3.12.0"


dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.apache.commons:commons-lang3:$apacheCommonsVersion")
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "${project.group}.$mainClassName")
    }
    from(configurations.compileClasspath.map { config -> config.map { if (it.isDirectory) it else zipTree(it) } })
}