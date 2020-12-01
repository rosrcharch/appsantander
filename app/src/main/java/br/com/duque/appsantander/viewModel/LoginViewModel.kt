package br.com.duque.appsantander.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.duque.appsantander.listener.APIListener
import br.com.duque.appsantander.model.User
import br.com.duque.appsantander.model.UserAccount
import br.com.duque.appsantander.repository.UserRepository

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val mUserRepository = UserRepository()

    private val mLogin = MutableLiveData<Boolean>()
    var login: LiveData<Boolean> = mLogin

    /**
     * faz login usando API
     */
    fun doLogin(user: String, password: String){
        mUserRepository.login(user, password, object  : APIListener{
            override fun onSuccess(model: UserAccount) {
                mLogin.value = true
            }

            override fun onFailure(str: String) {
                mLogin.value = false
            }

        })
    }

    /**
     * verifica se usuario esta logado
     */
    fun virifyLoggedUser(){

    }
}