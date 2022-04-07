package com.example.wallet.data

import com.example.wallet.MercadoBitcoinData
import io.reactivex.Single
import retrofit2.http.GET

interface MercadoBitcoinService {
    @GET("BTC/ticker/")
    fun bitcoinDay(): Single<List<MercadoBitcoinData>>
}
