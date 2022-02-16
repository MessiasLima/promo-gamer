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

    // DataStore
    implementation(DataStore.preferences)

    // Testing
    testImplementation(Kotlin.coroutinesTest)

    // Misc
    implementation(ThreeTenAbp.threeTenAbp)

    // Modules
    implementation(project(AppModule.Component.preferences_contract))
}