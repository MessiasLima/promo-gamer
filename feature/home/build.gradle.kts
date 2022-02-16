plugins {
    id(Android.GradlePlugin.library)
    id(Kotlin.GradlePlugin.android)
}

apply(from = "$rootDir/script/module/feature.gradle")

dependencies {
    implementation(project(AppModule.Feature.home_contract))
    implementation(project(AppModule.Feature.latest_deals_contract))
}