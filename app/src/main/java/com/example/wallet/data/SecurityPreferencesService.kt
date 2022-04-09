package com.example.wallet.data

import android.app.Application
import com.example.wallet.data.entity.ItemExtract
import com.example.wallet.util.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class SecurityPreferencesService(application: Application) {
    private val encryptedPreferences = SharedPreferences.create(application)

    //salva ArrayList offline do preferences ex {key: [arraylist]}
    fun saveArrayList(list: java.util.ArrayList<ItemExtract?>?, key: String?) {
        val editor =  encryptedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    //pega ArrayList offline do preferences ex {key: [arraylist]}
    fun getArrayList(key: String?): ArrayList<ItemExtract?>? {
        val prefs = encryptedPreferences
        val gson = Gson()
        val json: String? = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<ItemExtract?>?>() {}.getType()
        return gson.fromJson(json, type)
    }

    //seta uma chave e valor no preferences ex: {key: value}
    fun setKeyValue(coin: String, value: Int){
        encryptedPreferences.edit()
            .putInt(coin, value)
            .apply()
    }

    fun getInt(coin: String, value: Int): Int{
        return encryptedPreferences.getInt(coin, value)
    }
}