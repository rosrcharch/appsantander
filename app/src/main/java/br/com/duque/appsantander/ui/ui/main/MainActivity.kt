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
import br.com.duque.appsantander.ui.ui.details.DetailsActivity
import br.com.duque.appsantander.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        //inicializa os eventos
        setListeners()
        observer()

        //verifica se usuario esta logado
        verifyLoggerUser()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnLogin){
            handlerLogin()
        }

    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners(){
        btnLogin.setOnClickListener(this)
    }

    /**
     * Verifica se usuario esta logado
     */
    private fun verifyLoggerUser(){
        mViewModel.verifyLoggedUser()
    }

    /**
     * Observa ViewModel
     */
    private fun observer(){
        mViewModel.login.observe(this, Observer {
            if (it.success()){
                startActivity(Intent(this, DetailsActivity::class.java))
            }else{
                val message = it.failure()
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })

        mViewModel.loggedUser.observe(this, Observer {
            if (it){
                startActivity(Intent(this, DetailsActivity::class.java))
            }
        })

    }

    /**
     * autentica usuario
     */
    private fun handlerLogin(){

        var user = edt_user.text.toString()
        var password = edt_password.text.toString()

        mViewModel.doLogin(user, password)
    }

}