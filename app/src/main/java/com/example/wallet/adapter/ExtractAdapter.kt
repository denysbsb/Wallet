package com.example.wallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import java.util.ArrayList

//Opcao para adapter e recyclerview
class ExtractAdapter(private val mContacts: ArrayList<Int?>?) : RecyclerView.Adapter<ExtractAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.valor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_extract, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val contact: Int? = mContacts?.get(position)
        val textView = viewHolder.nameTextView
        if (contact != null) {
            textView.setText(contact)
        }

    }

    override fun getItemCount(): Int {
        return mContacts?.size ?: 0
    }
}
