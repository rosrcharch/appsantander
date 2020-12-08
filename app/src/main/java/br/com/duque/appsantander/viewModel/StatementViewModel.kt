package br.com.duque.appsantander.viewModel

import SharedPreferences
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.duque.appsantander.listener.APIListener
import br.com.duque.appsantander.listener.ReturnListener
import br.com.duque.appsantander.listener.ValidationListener
import br.com.duque.appsantander.model.StatementModel
import br.com.duque.appsantander.model.UserAccount
import br.com.duque.appsantander.repository.StatementRepository
import br.com.duque.appsantander.util.Constants

class StatementViewModel(application: Application): AndroidViewModel(application) {

    private val mStatementRepository = StatementRepository(application)
    private val mSharedPreferences = SharedPreferences(application)

    private var mList = MutableLiveData<List<StatementModel>>()
    val list: LiveData<List<StatementModel>>
        get() = mList


    fun getListStatement() {
        mStatementRepository.getLista(object : ReturnListener{
            override fun save(list: List<StatementModel>) {
                mList.value = list
            }

        })

    }

}