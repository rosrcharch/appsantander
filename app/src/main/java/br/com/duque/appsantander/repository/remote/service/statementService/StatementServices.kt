package br.com.duque.appsantander.repository.remote.service.statementService

import br.com.duque.appsantander.model.StatementModel
import retrofit2.Call
import retrofit2.http.GET

interface StatementServices {

    @GET("/api/login/statement")
    fun getStatement(): Call<List<StatementModel>>
}