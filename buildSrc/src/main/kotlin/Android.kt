object Android {
    const val applicationId = "com.messiaslima.promogamer"
    const val minSdk = 26
    const val targetSdk = 31
    const val compileSdk = targetSdk

    object Version {
        const val code = 9
        const val name = "2.0.0"
    }

    val gradlePlugin = GradlePlugin
    object GradlePlugin {
        const val version = "7.1.0"
        const val application = "com.android.application"
        const val library = "com.android.library"
    }
}
