plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
}

apply(from = "$rootDir/script/module/core.gradle")

android {
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

dependencies {
    // Core
    implementation(Core.coreKtx)

    // Compose
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.navigation)
    implementation(Compose.uiTooling)
    debugImplementation(Compose.uiTestManifest)
    androidTestImplementation(Compose.uiTestJunit4)

    // Modules
    implementation(project(AppModule.Core.navigation_contract))
}