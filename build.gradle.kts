plugins {
    id(Android.GradlePlugin.application) version Android.GradlePlugin.version apply false
    id(Android.GradlePlugin.library) version Android.GradlePlugin.version apply false
    id(Kotlin.GradlePlugin.android) version Kotlin.GradlePlugin.androidVersion apply false
    id(Detekt.gradlePlugin) version Detekt.version
    id("dependency-updater")
    id("git-hooks")
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}