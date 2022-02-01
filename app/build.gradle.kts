plugins {
    id(Android.GradlePlugin.application)
    id(Kotlin.GradlePlugin.android)
    id(Detekt.gradlePlugin)
}

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
        release {
            isMinifyEnabled = false
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

detekt {
    autoCorrect = true
    source = files(
        "src/main/java",
        "src/test/java",
        "src/androidTest/java",
        "src/main/kotlin",
        "src/test/kotlin",
        "src/androidTest/kotlin",
        "${rootDir}/buildSrc/src/main/kotlin"
    )
    config = files("${rootDir}/detekt.yml")
    parallel = true
    buildUponDefaultConfig = true
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

    // Plugins
    detektPlugins(Detekt.formatting)

    // Testing
    testImplementation(Junit.junit)
    androidTestImplementation(Test.Ext.junit)
    androidTestImplementation(Test.Espresso.core)
}