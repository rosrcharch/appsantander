package br.com.duque.appsantander.ui.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.duque.appsantander.R
import br.com.duque.appsantander.model.StatementModel
import br.com.duque.appsantander.repository.remote.service.statementService.StatementServices
import br.com.duque.appsantander.repository.remote.service.userService.RetrofitUser
import br.com.duque.appsantander.util.Adapter
import kotlinx.android.synthetic.main.activity_datails.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datails)

        val recyclerview = recycler_view
        recyclerview.adapter = Adapter(statements(), this)
        val layoutManeger = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = layoutManeger
    }


    private fun statements(): List<StatementModel> {

        return listOf(
                StatementModel("pagamento","Conta de agua", "11/02/1998","2.000"),
                StatementModel("pagamento","Conta de agua", "11/02/1998","2.000"),
                StatementModel("pagamento","Conta de agua", "11/02/1998","2.000"),
                StatementModel("pagamento","Conta de agua", "11/02/1998","2.000"),
                StatementModel("pagamento","Conta de agua", "11/02/1998","2.000")
        )

    }


}