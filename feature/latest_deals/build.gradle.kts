plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
}

apply(from = "$rootDir/script/module/feature.gradle")

dependencies {
    implementation(project(Module.Core.ui))
    implementation(project(Module.Feature.home_contract))
}