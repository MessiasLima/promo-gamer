plugins {
    id("com.star-zero.gradle.githook")
}

githook {
    failOnMissingHooksDir = true
    createHooksDirIfNotExist = true
    hooks {
        create("pre-push") {
            task = "detekt"
        }
    }
}
