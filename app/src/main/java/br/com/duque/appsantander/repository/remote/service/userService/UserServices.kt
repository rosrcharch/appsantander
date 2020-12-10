package br.com.duque.appsantander.repository.remote.service.userService

import br.com.duque.appsantander.model.UserAccount
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserServices {

    @POST("Authentication/Login")
    @FormUrlEncoded
    fun acessUser(@Field("email")user: String,
                  @Field("password")password: String): Call<UserAccount>
}