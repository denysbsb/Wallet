package com.example.wallet.activity

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.R
import com.example.wallet.databinding.ActivitySellCoinBinding
import com.example.wallet.viewModel.SellCoinViewModel

class SellCoinActivity : AppCompatActivity() {
    private lateinit var viewModel: SellCoinViewModel
    private lateinit var binding: ActivitySellCoinBinding
    var type = "compra"
    var item = "BITCOIN_EXTRACT"

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
    
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_bitcoin ->
                    if (checked) {
                        item = "BITCOIN_EXTRACT"
                    }
                R.id.radio_britas ->
                    if (checked) {
                        item = "BRITAS_EXTRACT"
                    }
            }
        }
    }
    
    fun onRadioButtonClickedItem(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_compra ->
                    if (checked) {
                        type = "compra"
                    }
                R.id.radio_venda ->
                    if (checked) {
                        type = "venda"
                    }
            }
        }
    }
    //salva dados do radiobutton e edittext com valor
    fun saveValue(){
        viewModel.saveBalanceExtract(item ,binding.value.text.toString().toInt(),type)
    }
}
