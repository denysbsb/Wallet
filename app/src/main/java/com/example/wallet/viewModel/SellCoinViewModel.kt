package com.example.wallet.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wallet.data.SecurityPreferencesService
import com.example.wallet.data.entity.ItemExtract
import java.util.ArrayList

class SellCoinViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SecurityPreferencesService(application)

    //salva extrato offline (valor, moeda, tipo)
    fun saveBalanceExtract(coin: String?, value: Int, type: String) {
        var list: ArrayList<ItemExtract?> = ArrayList()
        if(encryptedPreferences.getArrayList(coin) != null){
            list = encryptedPreferences.getArrayList(coin)!!
        }
        list?.add(ItemExtract(value,coin!!,type))
        encryptedPreferences.saveArrayList(list, coin)
    }
}