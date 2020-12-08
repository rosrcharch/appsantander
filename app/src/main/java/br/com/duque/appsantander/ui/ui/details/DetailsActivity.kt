package br.com.duque.appsantander.ui.ui.details

import SharedPreferences
import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.duque.appsantander.R
import br.com.duque.appsantander.model.StatementModel
import br.com.duque.appsantander.ui.ui.main.MainActivity
import br.com.duque.appsantander.util.Adapter
import br.com.duque.appsantander.util.Constants
import br.com.duque.appsantander.viewModel.StatementViewModel
import kotlinx.android.synthetic.main.activity_datails.*

class DetailsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: StatementViewModel
    private lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datails)

        mViewModel = ViewModelProvider(this).get(StatementViewModel::class.java)

        recyclerview = recycler_view
        var layoutManeger = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = layoutManeger


        //Inicia os eventos de lista
        observer()

        //Inicia o logout
        setListeners()

    }

    /**
     *Observa as listas
     */
    private fun observer(){
        mViewModel.list.observe(this, Observer {
            if(it != null)
            recyclerview.adapter = Adapter(it, this)
        })
        mViewModel.getListStatement()

        mViewModel.logout.observe(this, Observer {
            startActivity(Intent(this, MainActivity::class.java))
        })

    }

    override fun onClick(v: View) {
        if (v.id == R.id.icone_logout ){
            mViewModel.logout()
        }
    }

    /**
     * Inicia o evento de Logout
     */
    private fun setListeners(){
        icone_logout.setOnClickListener(this)
    }


}