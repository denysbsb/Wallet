package com.example.wallet.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wallet.data.SecurityPreferencesService
import com.example.wallet.data.entity.ItemExtract
import java.util.ArrayList

class ExtractViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SecurityPreferencesService(application)

    //Pega dados gravados offline do extrato
    fun getArrayList(key: String?): ArrayList<ItemExtract?>? {
        return encryptedPreferences.getArrayList(key)
    }
}