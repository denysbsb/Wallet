package com.example.wallet.viewModel

import com.example.wallet.util.SharedPreferences
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wallet.data.BcbService
import com.example.wallet.data.entity.ItemExtractData
import com.example.wallet.data.MercadoBitcoinService
import com.example.wallet.data.SecurityPreferencesService
import retrofit2.Retrofit

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val encryptedPreferences = SecurityPreferencesService(application)

    fun setBalance(coin: String, value: Int){
        encryptedPreferences.setKeyValue(coin,value)
    }

    //pega saldo subtraindo ou somando extrato
    fun getBalance(coin: String): Int {
        var value = encryptedPreferences.getInt(coin, 0)
        var list = encryptedPreferences.getArrayList(coin+"_EXTRACT")
        list?.forEach { it ->

            if(it!!.operation == "compra"){
                value = value.plus(it!!.value)
            } else {
                value = value.minus(it!!.value)
            }
        }
        return value
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