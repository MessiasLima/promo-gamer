plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
}

apply(from = "$rootDir/script/module/feature.gradle")

dependencies {
    implementation(Activity.compose)

    implementation(project(Module.Core.ui))
    implementation(project(Module.Core.network_contract))
    implementation(project(Module.Core.database_contract))
    implementation(project(Module.domain))
}