plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
    id(Kotlin.GradlePlugin.kapt)
    id(Hilt.GradlePlugin.plugin)
}

apply(from = "$rootDir/script/module/core.gradle")

dependencies {
    // Retrofit
    implementation(Retrofit2.retrofit)
    implementation(Retrofit2.converterGson)

    // Hilt
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    implementation(project(Module.Core.network_contract))
    implementation(project(Module.domain))
}