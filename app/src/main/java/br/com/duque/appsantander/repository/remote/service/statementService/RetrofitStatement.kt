package br.com.duque.appsantander.repository.remote.service.statementService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitStatement private constructor() {

    companion object{
        private lateinit var retrofit: Retrofit
        private const val BASE_URL = "https://bank-app-test.herokuapp.com/"

        private fun getRetrofitInstance(): Retrofit {

            var httpClient = OkHttpClient.Builder()
            if (!Companion::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit
        }

        fun <S> createServices(servicesClass: Class<S>): S {
            return getRetrofitInstance().create(servicesClass)
        }
    }
}