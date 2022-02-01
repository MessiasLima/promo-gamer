package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class CoreModule : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        applyPlugins()
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply(Android.GradlePlugin.library)
            apply(Kotlin.GradlePlugin.android)
        }
    }
}
