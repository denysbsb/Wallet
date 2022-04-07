package com.example.wallet.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.data.entity.ItemExtract
import com.example.wallet.databinding.ActivityExtractBinding
import com.example.wallet.viewModel.ExtractViewModel
import java.util.ArrayList

class ExtractActivity : AppCompatActivity() {
    private lateinit var viewModel: ExtractViewModel
    private lateinit var binding: ActivityExtractBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExtractViewModel::class.java)
        binding = ActivityExtractBinding.inflate(layoutInflater)

        //Pega extrato em preferences se tiver Bitcoin e Britas
        var list = viewModel.getArrayList("BITCOIN_EXTRACT")
        var listBritas = viewModel.getArrayList("BRITAS_EXTRACT")
        binding.custName.setText(transformList(list).toString())
        binding.custNameBritas.setText(transformList(listBritas).toString())

        binding.voltar.setOnClickListener { finish() }

        setContentView(binding!!.root)
    }
    //Transforma lista para exibição String (tipo-valor-simbolo)
    fun transformList(list: ArrayList<ItemExtract?>?): StringBuilder {
        val stringBuilder = StringBuilder()
        if (list != null) {
            list.forEach {
                stringBuilder.append(it?.type + "-")
                stringBuilder.append(it?.value.toString())
                if(it?.operation == "compra"){
                    stringBuilder.append("+"+ "\n")
                } else {
                    stringBuilder.append("-"+ "\n")
                }
            }
        }
        return stringBuilder
    }
}