package com.example.cryptocurrency.data.repository

import com.example.cryptocurrency.core.utils.Resource
import com.example.cryptocurrency.data.remote.CoinPaprikaApi
import com.example.cryptocurrency.data.remote.dto.CoinDetailsDto
import com.example.cryptocurrency.data.remote.dto.CoinDto
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetails
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class CoinRepositoryImpl(
    private val api: CoinPaprikaApi
): CoinRepository {
    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server. Check your Internet connection."))
        }
    }

    override fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>> = flow {

        try {
            emit(Resource.Loading())
            val coinDescription = api.getCoinById(coinId = coinId).toCoinDetails()
            emit(Resource.Success(coinDescription))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could not reach the server. Check your Internet connection."))
        }
    }
}