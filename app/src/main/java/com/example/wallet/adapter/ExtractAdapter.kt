package com.example.wallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.activity.ExtractActivity
import com.example.wallet.activity.MainActivity
import com.example.wallet.data.entity.ItemExtractData
import java.util.ArrayList

//Opcao para adapter e recyclerview extrato
class ExtractAdapter(private val dataSet: ArrayList<ItemExtractData?>?, mainActivity: ExtractActivity) :
    RecyclerView.Adapter<ExtractAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txOperetion: TextView
        val txType: TextView
        val txValue: TextView
        init {
            txOperetion = view.findViewById(R.id.operation)
            txType = view.findViewById(R.id.type)
            txValue = view.findViewById(R.id.value)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_extract, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if(dataSet != null) {
            var signal = "+"
            if(dataSet[position]!!.operation != "compra"){ signal = "-" }
            viewHolder.txOperetion.text = signal
            viewHolder.txType.text = dataSet[position]!!.type
            viewHolder.txValue.text = dataSet[position]!!.value.toString()
        }
    }

    override fun getItemCount() = dataSet!!.size

}