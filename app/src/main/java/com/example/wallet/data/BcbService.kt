package com.example.wallet.data

import com.example.wallet.BcbDatas
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

//Chama API do banco central para pegar valor do dolar
interface BcbService {
    @GET("olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='{data}'&\$top=100&\$format=json")
    fun dolarDay(@Query("data") data: String?): Single<BcbDatas>
}