package com.example.wallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SharedPreferences.create(application)
    fun setBalance(coin: String, value: Int){
        encryptedPreferences.edit()
            .putInt(coin, value)
            .apply()
    }
    fun getBalance(coin: String): Int {
        return encryptedPreferences.getInt(coin, 0)
    }
}