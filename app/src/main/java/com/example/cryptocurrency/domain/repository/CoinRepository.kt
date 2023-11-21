package com.example.cryptocurrency.domain.repository

import com.example.cryptocurrency.core.utils.Resource
import com.example.cryptocurrency.data.remote.dto.CoinDetailsDto
import com.example.cryptocurrency.data.remote.dto.CoinDto
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetails
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun getCoins(): Flow<Resource<List<Coin>>>

    fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>>
}