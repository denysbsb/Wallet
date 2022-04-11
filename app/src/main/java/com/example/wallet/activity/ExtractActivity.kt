package com.example.wallet.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallet.adapter.ExtractAdapter
import com.example.wallet.data.entity.ItemExtractData
import com.example.wallet.databinding.ActivityExtractBinding
import com.example.wallet.viewModel.ExtractViewModel
import java.util.ArrayList

class ExtractActivity : AppCompatActivity() {
    private lateinit var viewModel: ExtractViewModel
    private lateinit var binding: ActivityExtractBinding
    var extractList = ArrayList<ItemExtractData>()
    var listAdapter: ExtractAdapter? = null
    var listAdapterBritas: ExtractAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    var linearLayoutManagerBritas: LinearLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExtractViewModel::class.java)
        binding = ActivityExtractBinding.inflate(layoutInflater)
        binding.voltar.setOnClickListener { finish() }

        setContentView(binding!!.root)
    }

    override fun onResume() {
        super.onResume()
        extractList.add(ItemExtractData(12,"denys", "fontenele"))
        initView()
    }

    private fun initView(){
        //Pega extrato em preferences se tiver Bitcoin
        var list = viewModel.getArrayList("BITCOIN_EXTRACT")
        listAdapter = ExtractAdapter(list, this)
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManagerBritas = LinearLayoutManager(this)

        binding.recyclerview.layoutManager = linearLayoutManager
        binding.recyclerview.adapter = listAdapter

        //Pega extrato em preferences se tiver Britas
        var listBritas = viewModel.getArrayList("BRITAS_EXTRACT")
        listAdapterBritas = ExtractAdapter(listBritas, this)
        binding.recyclerviewBritas.layoutManager = linearLayoutManagerBritas
        binding.recyclerviewBritas.adapter = listAdapterBritas
    }
}