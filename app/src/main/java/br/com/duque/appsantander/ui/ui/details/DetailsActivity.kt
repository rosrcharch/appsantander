package br.com.duque.appsantander.ui.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.duque.appsantander.R
import br.com.duque.appsantander.model.StatementModel
import br.com.duque.appsantander.util.Adapter
import br.com.duque.appsantander.viewModel.StatementViewModel
import kotlinx.android.synthetic.main.activity_datails.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var mViewModel: StatementViewModel
    val listAdapter = Adapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datails)

        mViewModel = ViewModelProvider(this).get(StatementViewModel::class.java)



        var recyclerview = recycler_view
       // recyclerview.adapter = Adapter(mViewModel.getListStatement(), this)
        var layoutManeger = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = layoutManeger


        //Inicia os eventos de lista
        observer()

    }

    /**
     *Observa as listas
     */
    private fun observer(){
        mViewModel.list.observe(this, Observer {
            if (it != null)
            listAdapter.update(it)
        })

    }


}