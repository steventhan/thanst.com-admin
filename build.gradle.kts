plugins {
    kotlin("jvm") version DependencyVersions.kotlinVersion
}


repositories {
    mavenLocal()
    mavenCentral()
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${DependencyVersions.kotlinVersion}")
}