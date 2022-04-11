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
    var listAdapter: ExtractAdapter? = null
    var listAdapterBritas: ExtractAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExtractViewModel::class.java)
        binding = ActivityExtractBinding.inflate(layoutInflater)
        binding.voltar.setOnClickListener { finish() }
        setContentView(binding!!.root)
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView(){
        //Extrato em preferences se tiver Bitcoin
        listAdapter = ExtractAdapter(getExtract("BITCOIN_EXTRACT"), this)
        binding.recyclerview.layoutManager = getLinear()
        binding.recyclerview.adapter = listAdapter

        //Extrato em preferences se tiver Britas
        listAdapterBritas = ExtractAdapter(getExtract("BRITAS_EXTRACT"), this)
        binding.recyclerviewBritas.layoutManager = getLinear()
        binding.recyclerviewBritas.adapter = listAdapterBritas
    }

    fun getExtract(coin: String): ArrayList<ItemExtractData?>? {
        return viewModel.getArrayList(coin)
    }

    fun getLinear(): LinearLayoutManager {
        return LinearLayoutManager(this)
    }
}