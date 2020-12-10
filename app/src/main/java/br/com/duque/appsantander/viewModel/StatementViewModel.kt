package br.com.duque.appsantander.viewModel

import SharedPreferences
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.duque.appsantander.listener.ReturnList
import br.com.duque.appsantander.model.StatementModel
import br.com.duque.appsantander.repository.StatementRepository
import br.com.duque.appsantander.util.Constants

class StatementViewModel(application: Application) : AndroidViewModel(application) {

    private val mStatementRepository = StatementRepository(application)
    private val mSharedPreferences = SharedPreferences(application)

    private val mLoading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = mLoading

    private val mError = MutableLiveData<Boolean>()
    var error: LiveData<Boolean> = mError

    private val mLogout = MutableLiveData<Boolean>()
    var logout: LiveData<Boolean> = mLogout

    private val mList = MutableLiveData<List<StatementModel>>()
    var list: LiveData<List<StatementModel>> = mList


    /**
     * retorno de lista usando api
     */
    fun getListStatement() {
        mStatementRepository.getList(object : ReturnList {

            override fun onSuccess(list: List<StatementModel>) {

                if (list != null) {
                    mLoading.value = false
                    mError.value = false
                    mList.value = list
                } else {
                    mError.value = true
                    mLoading.value = false
                }

            }

            override fun onFailure(loading: Boolean) {
                if (loading != null){
                    mError.value = true
                    mLoading.value = false
                }
            }

        })

    }

    fun logout() {

        mSharedPreferences.remove(Constants.SHARED.USER)
        mSharedPreferences.remove(Constants.SHARED.PASSWORD)

        mLogout.value = true
    }

}