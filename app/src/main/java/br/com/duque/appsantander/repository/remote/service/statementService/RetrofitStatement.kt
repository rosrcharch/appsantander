package br.com.duque.appsantander.repository.remote.service.statementService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitStatement private constructor() {

    companion object{
        private lateinit var retrofit: Retrofit
        private const val BASE_URL = "https://5fca7fdb3c1c2200164427c6.mockapi.io"

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

        fun <S> createStatementServer(servicesClass: Class<S>): S {
            return getRetrofitInstance().create(servicesClass)
        }
    }
}