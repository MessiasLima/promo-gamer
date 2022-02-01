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
    implementation(Activity.compose)
    implementation(Lifecycle.runtimeKtx)

    // Compose
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiToolingPreview)
    androidTestImplementation(Compose.uiTestJunit4)
    debugImplementation(Compose.uiTooling)
    debugImplementation(Compose.uiTestManifest)

    // Testing
    androidTestImplementation(Test.Ext.junit)
    androidTestImplementation(Test.Espresso.core)
}