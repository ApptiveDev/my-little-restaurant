plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.diffplug.spotless") version "7.2.1"
}

android {
    namespace = "com.apptive.mylittlerestaurant"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.apptive.mylittlerestaurant"
        minSdk = 33
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }
    }
    buildFeatures {
        compose = true
    }
    buildToolsVersion = "33.0.1"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.benchmark.traceprocessor)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.compose.ui:ui:1.6.8")
    implementation("androidx.compose.foundation:foundation:1.6.8")

}

spotless {
    kotlin {
        target("**/*.kt")
        ktlint("0.50.0")
        trimTrailingWhitespace()
        endWithNewline()
    }

    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint("0.50.0")
        trimTrailingWhitespace()
        endWithNewline()
    }

    java {
        target("**/*.java")
        trimTrailingWhitespace()
        endWithNewline()
        removeUnusedImports()
    }
}

tasks.register("createSpotlessPreCommitHook") {
    doLast {
        val gitHooksDirectory = File("${project.rootDir}/.git/hooks")
        if (!gitHooksDirectory.exists()) {
            gitHooksDirectory.mkdirs()
        }
        File(gitHooksDirectory, "pre-commit").writeText(
            """
            #!/bin/bash
            echo "Running spotless check"
            ./gradlew spotlessApply
            if [ \$? -eq 0 ]; then
                echo "Spotless check succeed"
            else
                echo "Spotless check failed" >&2
                exit 1
            fi
            """.trimIndent(),
        )

        // 실행 권한 부여 (deprecated exec -> ProcessBuilder로 변경)
        ProcessBuilder("chmod", "+x", "$gitHooksDirectory/pre-commit")
            .inheritIO()
            .start()
            .waitFor()
    }
}
