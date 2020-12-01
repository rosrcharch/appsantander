package br.com.duque.appsantander.ui.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.duque.appsantander.R
import br.com.duque.appsantander.model.User
import br.com.duque.appsantander.repository.UserRepository
import br.com.duque.appsantander.repository.remote.service.userService.RetrofitUser
import br.com.duque.appsantander.repository.remote.service.userService.UserServices
import br.com.duque.appsantander.ui.ui.details.DetailsActivity
import br.com.duque.appsantander.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


    }

    override fun onClick(v: View?) {
       if (v!!.id == R.id.btnLogin){
           handlerLogin()
           startActivity(Intent(this, DetailsActivity::class.java))
       }
    }

    /**
     * Verifica se usuario esta logado
     */
    private fun verifyLoggerUser(){
        mViewModel.virifyLoggedUser()
    }

    /**
     * inicia evento de click
     */
    private fun setListeners(){
        btnLogin.setOnClickListener(this)
    }

    /**
     * Observa ViewModel
     */
    private fun observer(){
        mViewModel.login.observe(this, Observer {
            if (it){
                startActivity(Intent(this, DetailsActivity::class.java))
            }else{
                Toast.makeText(this, "Erro de login", Toast.LENGTH_SHORT).show()
            }
        })

    }

    /**
     * autentica usuario
     */
    private fun handlerLogin(){
        var userModel = User()
        userModel.user = edtUser.text.toString()
        userModel.password = edtPassword.text.toString()

        mViewModel.doLogin(userModel.user, userModel.password)
    }



}