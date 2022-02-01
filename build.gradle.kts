import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id(Android.GradlePlugin.application) version Android.GradlePlugin.version apply false
    id(Android.GradlePlugin.library) version Android.GradlePlugin.version apply false
    id(Kotlin.GradlePlugin.android) version Kotlin.GradlePlugin.androidVersion apply false
    id(Detekt.gradlePlugin) version Detekt.version
    id("com.github.ben-manes.versions") version "0.41.0"
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version) || isOnIgnoreList(candidate.module)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

fun isOnIgnoreList(module: String): Boolean {
    return listOf(
        "jacoco",
        "android.gradle.plugin"
    ).any {
        module.contains(it, ignoreCase = true)
    }
}