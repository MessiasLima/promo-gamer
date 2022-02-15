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

    // Room
    implementation(Room.runtime)
    implementation(Room.ktx)
    kapt(Room.compiler)

    // Modules
    implementation(project(Module.domain))
    implementation(project(Module.Core.database_contract))

    // Testing
    testImplementation(Kotlin.coroutinesTest)
}