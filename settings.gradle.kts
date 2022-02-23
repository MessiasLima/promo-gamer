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
include(":core:database_contract")
include(":core:navigation_contract")
include(":component:preferences")
include(":component:preferences_contract")
include(":feature:splash")
include(":feature:main")
include(":feature:home")
include(":feature:home_contract")
include(":feature:latest_deals")
include(":feature:latest_deals_contract")
include(":feature:latest_deals_games")
include(":feature:latest_deals_games_contract")
include(":feature:latest_deals_products")
include(":feature:latest_deals_products_contract")
include(":feature:saved_deals")
include(":feature:saved_deals_contract")
