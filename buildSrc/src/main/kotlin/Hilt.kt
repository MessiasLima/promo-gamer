object Hilt {
    private const val version = "2.40.5"

    const val android = "com.google.dagger:hilt-android:$version"
    const val compiler = "com.google.dagger:hilt-compiler:$version"

    val gradlePlugin = GradlePlugin
    object GradlePlugin {
        const val classpath = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val plugin = "dagger.hilt.android.plugin"
    }
}
