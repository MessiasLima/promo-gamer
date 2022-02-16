plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
}

apply(from = "$rootDir/script/module/feature.gradle")

dependencies {
    implementation(Activity.compose)
    implementation(ThreeTenAbp.threeTenAbp)

    implementation(project(AppModule.Core.ui))
    implementation(project(AppModule.Core.network_contract))
    implementation(project(AppModule.Core.database_contract))
    implementation(project(AppModule.Component.preferences_contract))
    implementation(project(AppModule.domain))
    implementation(project(AppModule.Feature.main))
}