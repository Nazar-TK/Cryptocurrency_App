package com.example.cryptocurrency.domain.use_case.get_coins

import com.example.cryptocurrency.core.utils.Resource
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetCoinsUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }
}