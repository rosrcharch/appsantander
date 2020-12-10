package br.com.duque.appsantander.ui.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.duque.appsantander.R
import br.com.duque.appsantander.ui.ui.main.MainActivity
import br.com.duque.appsantander.util.Adapter
import br.com.duque.appsantander.viewModel.StatementViewModel
import kotlinx.android.synthetic.main.activity_datails.*

class DetailsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: StatementViewModel
    private lateinit var recyclerview: RecyclerView
    private lateinit var listError: TextView
    private lateinit var loading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datails)

        mViewModel = ViewModelProvider(this).get(StatementViewModel::class.java)

        listError = txt_error
        loading = loading_view

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
    private fun observer() {
        mViewModel.list.observe(this, Observer {
            if (it != null){
                recyclerview.visibility = View.VISIBLE
                recyclerview.adapter = Adapter(it, this)
            }

        })
        mViewModel.getListStatement()

        mViewModel.logout.observe(this, Observer {
            startActivity(Intent(this, MainActivity::class.java))
        })

        mViewModel.error.observe(this, Observer {
          if (it != false){
              listError.visibility = View.VISIBLE
              loading.visibility = View.GONE
              recyclerview.visibility = View.GONE
          } else {
              listError.visibility = View.GONE
          }
        })

        mViewModel.loading.observe(this, Observer {
            if (it != false){
                loading.visibility = View.VISIBLE
                recyclerview.visibility = View.GONE
                listError.visibility = View.GONE
            } else {
                loading.visibility = View.GONE
            }
        })

    }

    override fun onClick(v: View) {
        if (v.id == R.id.icone_logout) {
            mViewModel.logout()
            finish()
        }
    }

    /**
     * Inicia o evento de Logout
     */
    private fun setListeners() {
        icone_logout.setOnClickListener(this)
    }



}