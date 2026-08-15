import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.screenshot)
}

kotlin {
    jvmToolchain(17)
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

android {
    namespace = "io.github.kezlab.compose.pickers.screenshots"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

    experimentalProperties["android.experimental.enableScreenshotTest"] = true

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":pickers"))

    screenshotTestImplementation(libs.screenshot.validation.api)
    screenshotTestImplementation(libs.compose.ui.tooling)
    screenshotTestImplementation(libs.compose.material3)
    screenshotTestImplementation(libs.kotlinx.datetime)
}
