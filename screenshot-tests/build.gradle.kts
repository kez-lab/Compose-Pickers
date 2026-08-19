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
    // Keep this aligned with the other Android modules, which compile against 37. Anything
    // older fails the AAR metadata check: :pickers and the androidx Compose artifacts on the
    // screenshotTest classpath both declare a minimum compileSdk of 37.
    compileSdk = 37

    defaultConfig {
        minSdk = 24
    }

    // Both this and android.experimental.enableScreenshotTest in gradle.properties are required:
    // the plugin checks the project property when it is applied and this one when it configures
    // the module. Removing either fails the build.
    experimentalProperties["android.experimental.enableScreenshotTest"] = true

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    testOptions {
        screenshotTests {
            // Layoutlib antialiasing can differ by a hair between the machine that recorded a
            // reference image and the machine that validates it. Allow 0.01% of pixels to differ
            // so real visual regressions still fail while host noise does not.
            imageDifferenceThreshold = 0.0001f
        }
    }
}

dependencies {
    implementation(project(":pickers"))

    screenshotTestImplementation(libs.screenshot.validation.api)
    screenshotTestImplementation(libs.compose.ui.tooling)
    // @Preview itself comes from androidx; declare it instead of relying on a transitive path.
    screenshotTestImplementation(libs.androidx.ui.tooling.preview)
    screenshotTestImplementation(libs.compose.material3)
    screenshotTestImplementation(libs.kotlinx.datetime)
}

// The screenshot plugin does not wire validation into `check`, which would leave the reference
// images unguarded for anyone running the normal verification tasks.
tasks.named("check") {
    dependsOn("validateDebugScreenshotTest")
}
