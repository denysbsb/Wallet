package com.example.wallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.ArrayList

class SellCoinViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SharedPreferences.create(application)
    fun saveBalanceExtract(coin: String, value: Int) {
        var list = getArrayList(coin)
        list?.add(value)
        saveArrayList(list, coin)
    }
    fun saveArrayList(list: ArrayList<Int?>?, key: String?) {
        val editor =  encryptedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }
    fun getArrayList(key: String?): ArrayList<Int?>? {
        val prefs = encryptedPreferences
        val gson = Gson()
        val json: String? = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.getType()
        return gson.fromJson(json, type)
    }
}