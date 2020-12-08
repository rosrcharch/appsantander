package br.com.duque.appsantander.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.duque.appsantander.R
import br.com.duque.appsantander.model.StatementModel
import kotlinx.android.synthetic.main.item_recyclerview.view.*


class Adapter(private val statementList: ArrayList<StatementModel>, private val context: Context) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        var title = view.txt_title
        var desc = view.txt_desc
        var date = view.txt_data
        var valor = view.txt_value

    }

    fun update(newStatement: List<StatementModel>){
        statementList.clear()
        statementList.addAll(newStatement)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return statementList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val statement = statementList[position]
        holder.title.text = statement.title
        holder.desc.text = statement.desc
        holder.date.text = statement.date
        holder.valor.text = statement.value

    }
}