package br.com.duque.appsantander.util

/**
 * Contantes usadas na aplicação
 */
class Constants private constructor() {

    //SharedPreferences
    object SHARED{
        const val USER = "user"
        const val PASSWORD = "password"
    }

    object HEADER {
        const val PERSONKEY = "personkey"
        const val NAME = "name"
        const val TOKEN = "token"
        const val AGENCY = "agency"
        const val BALANCE = "balance"
    }

    object HTTP {
        const val SUCCESS = 200
    }
}