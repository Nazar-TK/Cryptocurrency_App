package com.example.cryptocurrency.domain.use_case.get_coin

import com.example.cryptocurrency.core.utils.Resource
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetails
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoinDescriptionUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> {
        if(coinId.isBlank()) {
            return flow { }
        }
        return repository.getCoinDetails(coinId = coinId)
    }
}