plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
    id(Kotlin.GradlePlugin.kapt)
}

apply(from = "$rootDir/script/module/core.gradle")

dependencies {
    implementation(Compose.navigation)
}