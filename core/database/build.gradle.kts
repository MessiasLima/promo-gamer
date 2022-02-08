plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
    id(Kotlin.GradlePlugin.kapt)
    id(Hilt.GradlePlugin.plugin)
    id(Ksp.gradlePlugin)
}

apply(from = "$rootDir/script/module/core.gradle")

dependencies {
    // Hilt
    implementation(Hilt.android)
    kapt(Hilt.compiler)

    // Room
    implementation(Room.runtime)
    implementation(Room.ktx)
    ksp(Room.compiler)

    // Modules
    // implementation(project(Module.Core.network_contract))
    implementation(project(Module.domain))

    // Testing
    testImplementation(Kotlin.coroutinesTest)
}