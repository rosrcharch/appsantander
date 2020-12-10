package br.com.duque.appsantander.repository.remote.service.userService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUser private constructor() {

    companion object {
        private lateinit var retrofit: Retrofit
        private const val BASE_URL = " http://devmasterteam.com/CursoAndroidAPI/ "

        private fun getRetrofitInstance(): Retrofit {

            var httpClient = OkHttpClient.Builder()
            if (!Companion::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit
        }

        fun <S> createUserServices(servicesClass: Class<S>): S {
            return getRetrofitInstance().create(servicesClass)
        }
    }
}