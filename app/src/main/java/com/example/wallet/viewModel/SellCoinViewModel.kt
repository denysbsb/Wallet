package com.example.wallet.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wallet.data.entity.ItemExtract
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.ArrayList
import com.example.wallet.util.SharedPreferences

class SellCoinViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SharedPreferences.create(application)

    //salva extrato offline (valor, moeda, tipo)
    fun saveBalanceExtract(coin: String?, value: Int, type: String) {
        var list: ArrayList<ItemExtract?> = ArrayList()
        if(getArrayList(coin) != null){
            list = getArrayList(coin)!!
        }
        list?.add(ItemExtract(value,coin!!,type))
        saveArrayList(list, coin)
    }

    //salva o array offline em json
    fun saveArrayList(list: ArrayList<ItemExtract?>?, key: String?) {
        val editor =  encryptedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    //pega dados de extrato offline
    fun getArrayList(key: String?): ArrayList<ItemExtract?>? {
        val prefs = encryptedPreferences
        val gson = Gson()
        val json: String? = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<ItemExtract?>?>() {}.getType()
        return gson.fromJson(json, type)
    }
}