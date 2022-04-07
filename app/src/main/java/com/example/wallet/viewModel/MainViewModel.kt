package com.example.wallet.viewModel

import com.example.wallet.util.SharedPreferences
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wallet.data.BcbService
import com.example.wallet.data.entity.ItemExtract
import com.example.wallet.data.MercadoBitcoinService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import java.lang.reflect.Type

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SharedPreferences.create(application)
    fun setBalance(coin: String, value: Int){
        encryptedPreferences.edit()
            .putInt(coin, value)
            .apply()
    }

    //pega saldo subtraindo ou somando extrato
    fun getBalance(coin: String): Int {
        var value = encryptedPreferences.getInt(coin, 0)
        var list = getArrayList(coin+"_EXTRACT")
        list?.forEach { it ->
            if(it!!.operation == "compra"){
                value = value + it!!.value
            } else {
                value = value - it!!.value
            }
        }
        return value
    }

    //pega dados extrato gravados offline
    fun getArrayList(key: String?): ArrayList<ItemExtract?>? {
        val prefs = encryptedPreferences
        val gson = Gson()
        val json: String? = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<ItemExtract?>?>() {}.getType()
        return gson.fromJson(json, type)
    }

    //Chama api bcb pegar dolar
    fun getDolarDay(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://olinda.bcb.gov.br/")
            .build()

        val service: BcbService = retrofit.create(BcbService::class.java)
        //    service.dolarDay("04-06-2022").subscribe({ dolar -> dolar })

    }

    //Chama api bcb pegar bitcoin
    fun getBitcoinDay(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.mercadobitcoin.net/api/")
            .build()

        val service: MercadoBitcoinService = retrofit.create(MercadoBitcoinService::class.java)
        //    service.bitcoinDay().subscribe({ bitcoin -> bitcoin })
    }
}