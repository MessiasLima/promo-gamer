plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("com.github.ben-manes:gradle-versions-plugin:0.41.0")
    implementation("com.star-zero.gradle:githook:1.2.1")
    //implementation("com.android.tools.build:gradle:7.1.0")
}
