package br.com.duque.appsantander.viewModel

import SharedPreferences
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.duque.appsantander.listener.APIListener
import br.com.duque.appsantander.listener.ValidationListener
import br.com.duque.appsantander.model.User
import br.com.duque.appsantander.model.UserAccount
import br.com.duque.appsantander.repository.UserRepository
import br.com.duque.appsantander.util.Constants

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val mUserRepository = UserRepository(application)
    private val mSharedPreferences = SharedPreferences(application)

    private val mLogin = MutableLiveData<ValidationListener>()
    var login: LiveData<ValidationListener> = mLogin

    private val mLoggedUser = MutableLiveData<Boolean>()
    var loggedUser: LiveData<Boolean> = mLoggedUser

    /**
     * faz login usando API
     */
    fun doLogin(user: String, password: String){
        mUserRepository.login(user, password, object  : APIListener{

            override fun onSuccess(model: UserAccount) {

                //Salvando retorno nos sharedPreferences
                mSharedPreferences.store(Constants.HEADER.USERID, model.userId.toString())
                mSharedPreferences.store(Constants.HEADER.NAME, model.name)
                mSharedPreferences.store(Constants.HEADER.BANKACCOUNT, model.bankAccount)
                mSharedPreferences.store(Constants.HEADER.AGENCY, model.agency)
                mSharedPreferences.store(Constants.HEADER.BALANCE, model.balance.toString())

                mLogin.value = ValidationListener()

            }

            override fun onFailure(str: String) {
                mLogin.value = ValidationListener(str)
            }

        })
    }

    /**
     * verifica se usuario esta logado
     */
    fun virifyLoggedUser(){

        val userid = mSharedPreferences.get(Constants.HEADER.USERID)
        val name = mSharedPreferences.get(Constants.HEADER.NAME)

        val logged = (userid != "" && name != "")
        mLoggedUser.value = logged


    }
}