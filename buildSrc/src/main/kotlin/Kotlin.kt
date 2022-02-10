object Kotlin {
    private const val coroutinesVersion = "1.5.2"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"

    val gradlePlugin = GradlePlugin

    object GradlePlugin {
        const val androidVersion = "1.5.31"
        const val android = "org.jetbrains.kotlin.android"
        const val jvm = "org.jetbrains.kotlin.jvm"
        const val kapt = "kotlin-kapt"
    }
}
