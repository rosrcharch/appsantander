package br.com.duque.appsantander.listener


import br.com.duque.appsantander.model.UserAccount

interface APIListener {

    fun onSuccess(model: UserAccount)
    fun onFailure(str: String)
}