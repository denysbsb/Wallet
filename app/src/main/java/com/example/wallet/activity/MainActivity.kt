package com.example.wallet.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallet.adapter.ExtractAdapter
import com.example.wallet.data.entity.ItemExtractData
import com.example.wallet.databinding.ActivityMainBinding
import com.example.wallet.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    var nameList = ArrayList<ItemExtractData>()
    var listaAdapter: ExtractAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(binding!!.root)
        getIniBalance()
        setBalance()
        setClicks()
    }

    fun setClicks(){
        binding.extract.setOnClickListener {
            val intent = Intent(this, ExtractActivity::class.java)
            startActivity(intent)
        }
        binding.sell.setOnClickListener {
            val intent = Intent(this, SellCoinActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setBalance()
    }

    //TODO ainda nao chamando api bitcoin e dolar direito
    fun getIniBalance(){
        viewModel.setBalance("BITCOIN",4)
        viewModel.getBitcoinDay()
        viewModel.setBalance("BRITAS",21321)
        viewModel.getDolarDay()
    }
    
    fun setBalance(){
        binding.balanceBitcoin.text = viewModel.getBalance("BITCOIN").toString()
        binding.balanceBritas.text = viewModel.getBalance("BRITAS").toString()
    }

}
