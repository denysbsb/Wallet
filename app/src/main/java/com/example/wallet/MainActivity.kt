package com.example.wallet

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(binding!!.root)
        getIniBalance()
        setBalance()
        setClicks()
       // viewModel.setBalanceExtract()
       // viewModel.setBalanceExtract()
        var items = viewModel.getBalance()

        items
    }

    fun setClicks(){
        binding.sell.setOnClickListener {
            val intent = Intent(this, SellCoinActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setBalance()
    }

    fun getIniBalance(){
        viewModel.setBalance("BITCOIN",50000)
        viewModel.setBalance("BRITAS",100)
    }
    fun setBalance(){
        binding.balanceBitcoin.text = viewModel.getBalance("BITCOIN").toString()
        binding.balanceBritas.text = viewModel.getBalance("BRITAS").toString()
    }

}