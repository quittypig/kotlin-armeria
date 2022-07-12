plugins {
    kotlin("jvm") version "1.6.21"

    id("com.google.protobuf") version  "0.8.15"

    id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

allprojects {
    group = "org.example"
    version = "0.0.1"

    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    }

}

detekt {
    allRules = false // activate all available (even unstable) rules.
    config = files("$rootDir/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
    buildUponDefaultConfig = true // preconfigure defaults
}
