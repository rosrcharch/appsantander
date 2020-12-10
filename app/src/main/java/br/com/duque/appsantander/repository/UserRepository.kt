package br.com.duque.appsantander.repository

import android.content.Context
import android.util.Log
import br.com.duque.appsantander.R
import br.com.duque.appsantander.listener.APIListener
import br.com.duque.appsantander.model.UserAccount
import br.com.duque.appsantander.repository.remote.service.userService.RetrofitUser
import br.com.duque.appsantander.repository.remote.service.userService.UserServices
import br.com.duque.appsantander.util.Constants
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(val context: Context) {

    /**
     * Put here your DAOs metods or Retrofit to Get Local or Remote Data
     */
    private val mRemote = RetrofitUser.createUserServices(UserServices::class.java)

    fun login(user: String, password: String, listener: APIListener){

        val call: Call<UserAccount> = mRemote.acessUser(user, password)
        call.enqueue(object : Callback<UserAccount>{
            override fun onFailure(call: Call<UserAccount>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<UserAccount>, response: Response<UserAccount>) {
                if (response.code() != Constants.HTTP.SUCCESS){
                    val validation = Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(validation)
                    Log.i("TAG", "onResponse: validação $validation")
                }else {
                    response.body()?.let { listener.onSuccess(it) }
                }

            }

        })

    }
}