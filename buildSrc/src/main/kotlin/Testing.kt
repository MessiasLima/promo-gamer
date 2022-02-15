object Testing {
    val ext = Ext
    object Ext {
        private const val extJunitVersion = "1.1.3"

        const val junit = "androidx.test.ext:junit:$extJunitVersion"
    }

    val espresso = Espresso
    object Espresso {
        private const val version = "3.4.0"

        const val core = "androidx.test.espresso:espresso-core:$version"
    }
}
