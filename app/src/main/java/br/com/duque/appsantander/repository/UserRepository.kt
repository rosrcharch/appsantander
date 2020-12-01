package br.com.duque.appsantander.repository

import android.util.Log
import br.com.duque.appsantander.listener.APIListener
import br.com.duque.appsantander.model.User
import br.com.duque.appsantander.model.UserAccount
import br.com.duque.appsantander.repository.remote.service.userService.RetrofitUser
import br.com.duque.appsantander.repository.remote.service.userService.UserServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    /**
     * Put here your DAOs metods or Retrofit to Get Local or Remote Data
     */
    private val mRemote = RetrofitUser.createServices(UserServices::class.java)

    fun login(user: String, password: String, listener: APIListener){

        val call: Call<UserAccount> = mRemote.acessUser(user, password)
        call.enqueue(object : Callback<UserAccount>{
            override fun onFailure(call: Call<UserAccount>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<UserAccount>, response: Response<UserAccount>) {
                response.body()?.let { listener.onSuccess(it) }

            }

        })

    }
}