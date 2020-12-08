package br.com.duque.appsantander.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import br.com.duque.appsantander.R
import br.com.duque.appsantander.listener.ReturnListener
import br.com.duque.appsantander.model.StatementModel
import br.com.duque.appsantander.repository.remote.service.statementService.RetrofitStatement
import br.com.duque.appsantander.repository.remote.service.statementService.StatementServices
import br.com.duque.appsantander.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatementRepository(val context: Context) {

    private val mRemote = RetrofitStatement.createStatementServer(StatementServices::class.java)


    fun getLista(listReturnListener: ReturnListener) {
        val call: Call<List<StatementModel>> = mRemote.getStatement()
        call.enqueue(object : Callback<List<StatementModel>> {

            override fun onFailure(call: Call<List<StatementModel>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<StatementModel>>, response: Response<List<StatementModel>>) {
                response.body()?.let { listReturnListener.save(it) }

            }

        })


    }


}