package br.com.duque.appsantander.repository

import android.content.Context
import br.com.duque.appsantander.R
import br.com.duque.appsantander.listener.ReturnList
import br.com.duque.appsantander.model.StatementModel
import br.com.duque.appsantander.repository.remote.service.statementService.RetrofitStatement
import br.com.duque.appsantander.repository.remote.service.statementService.StatementServices
import br.com.duque.appsantander.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatementRepository(val context: Context) {

    /**
     * Put here your DAOs metods or Retrofit to Get Local or Remote Data
     */
    private val mRemote = RetrofitStatement.createStatementServer(StatementServices::class.java)

    fun getList(listReturnListener: ReturnList) {
        val call: Call<List<StatementModel>> = mRemote.getStatement()
        call.enqueue(object : Callback<List<StatementModel>> {
            override fun onFailure(call: Call<List<StatementModel>>, t: Throwable) {
                listReturnListener.onFailure(true)
            }

            override fun onResponse(call: Call<List<StatementModel>>, response: Response<List<StatementModel>>) {
                if (response.code() == Constants.HTTP.SUCCESS && response.body() != null) {
                    response.body()?.let { listReturnListener.onSuccess(it) }
                } else {
                    listReturnListener.onFailure(true)
                }
            }

        })


    }


}