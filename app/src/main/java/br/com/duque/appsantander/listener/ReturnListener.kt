package br.com.duque.appsantander.listener

import br.com.duque.appsantander.model.StatementModel

interface ReturnListener {

    fun save(list: List<StatementModel>)
}