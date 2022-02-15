plugins {
    id(Android.GradlePlugin.application)
    id(Kotlin.GradlePlugin.android)
    id(Kotlin.GradlePlugin.kapt)
    id(Hilt.gradlePlugin.plugin)
}

apply(from = "$rootDir/script/detekt.gradle")

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.Version.code
        versionName = Android.Version.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isTestCoverageEnabled = true
            testCoverage {
                jacocoVersion = "0.8.7"
            }
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }

        create("minifiedDebug") {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = true
            applicationIdSuffix = ".minified"
            versionNameSuffix = "-minified"
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.version
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Core
    implementation(Core.coreKtx)
    implementation(Activity.compose)
    implementation(Lifecycle.runtimeKtx)

    // Compose
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiToolingPreview)
    androidTestImplementation(Compose.uiTestJunit4)
    debugImplementation(Compose.uiTooling)
    debugImplementation(Compose.uiTestManifest)

    // Hilt
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    // Testing
    testImplementation(Junit.junit)
    androidTestImplementation(Testing.Ext.junit)
    androidTestImplementation(Testing.Espresso.core)

    // Modules
    implementation(project(Module.Core.ui))
    implementation(project(Module.Core.network))
    implementation(project(Module.Core.database))
    implementation(project(Module.Component.preferences))
    implementation(project(Module.Feature.splash))
    implementation(project(Module.Feature.home))
}