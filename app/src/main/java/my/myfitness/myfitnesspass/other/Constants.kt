package my.myfitness.myfitnesspass.other

object Constants {

    const val DATABASE_NAME = "my_fitness_pass_db"

    const val KEY_LOGGED_IN_EMAIL = "KEY_LOGGED_IN_EMAIL"
    const val KEY_PASSWORD = "KEY_PASSWORD"

    const val ENCRYPTED_SHARED_PREF_NAME = "enc_shared_pref"

    const val BASE_URL = "http://192.168.43.130:8001"

    val IGNORE_AUTH_URLS = listOf("/login", "/register")
}