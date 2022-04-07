package com.example.wallet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.databinding.ActivitySellCoinBinding

class SellCoinActivity : AppCompatActivity() {
    private lateinit var viewModel: SellCoinViewModel
    private lateinit var binding: ActivitySellCoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SellCoinViewModel::class.java)
        binding = ActivitySellCoinBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setClicks()
    }
    fun setClicks(){
        binding.voltar.setOnClickListener { finish() }
        binding.executar.setOnClickListener {
            saveValue()
            finish()
        }

    }
    fun saveValue(){
        viewModel.saveBalanceExtract("BITCOIN_EXTRACT",binding.value.text.toString().toInt())
    }
}