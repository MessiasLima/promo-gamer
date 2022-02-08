@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PromoGamer"

include(":app")
include(":domain")
include(":core:ui")
include(":core:network")
include(":core:network_contract")
include(":core:database")
include(":feature:splash")
