plugins {
    id(Android.GradlePlugin.application) version Android.GradlePlugin.version apply false
    id(Android.GradlePlugin.library) version Android.GradlePlugin.version apply false
    id(Kotlin.GradlePlugin.android) version Kotlin.GradlePlugin.androidVersion apply false
    id(GitHook.gradlePlugin) version GitHook.version apply false
    id(DependencyUpdater.gradlePlugin) version DependencyUpdater.version apply false
    id(Detekt.gradlePlugin) version Detekt.version
}

apply(from = "$rootDir/script/githook.gradle")
apply(from = "$rootDir/script/dependency-updater.gradle")

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}