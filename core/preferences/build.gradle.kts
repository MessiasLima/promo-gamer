plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
    id(Kotlin.GradlePlugin.kapt)
    id(Hilt.GradlePlugin.plugin)
}

apply(from = "$rootDir/script/module/core.gradle")

dependencies {
    // Hilt
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    testImplementation(Kotlin.coroutinesTest)
}