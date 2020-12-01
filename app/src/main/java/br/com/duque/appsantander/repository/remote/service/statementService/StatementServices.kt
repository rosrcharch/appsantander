package br.com.duque.appsantander.repository.remote.service.statementService

import br.com.duque.appsantander.model.StatementModel
import retrofit2.Call
import retrofit2.http.GET

interface StatementServices {

    @GET("/api/statements/1")
    fun getStatement(): Call<List<StatementModel>>
}