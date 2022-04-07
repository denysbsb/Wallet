package com.example.wallet.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wallet.data.entity.ItemExtract
import com.example.wallet.util.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.ArrayList

class ExtractViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SharedPreferences.create(application)

    //Pega dados gravados offline do extrato
    fun getArrayList(key: String?): ArrayList<ItemExtract?>? {
        val prefs = encryptedPreferences
        val gson = Gson()
        val json: String? = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<ItemExtract?>?>() {}.getType()
        return gson.fromJson(json, type)
    }
}