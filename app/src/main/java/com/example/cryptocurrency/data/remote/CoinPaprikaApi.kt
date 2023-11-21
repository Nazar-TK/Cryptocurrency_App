package com.example.cryptocurrency.data.remote

import com.example.cryptocurrency.data.remote.dto.CoinDetailsDto
import com.example.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinID") coinId: String) : CoinDetailsDto

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/"
    }
}