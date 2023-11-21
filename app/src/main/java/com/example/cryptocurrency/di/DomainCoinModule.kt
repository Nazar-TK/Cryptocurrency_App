package com.example.cryptocurrency.di

import com.example.cryptocurrency.domain.repository.CoinRepository
import com.example.cryptocurrency.domain.use_case.get_coin.GetCoinDescriptionUseCase
import com.example.cryptocurrency.domain.use_case.get_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainCoinModule {

    @Provides
    fun provideGetCoinDescriptionUseCase(coinRepository: CoinRepository): GetCoinDescriptionUseCase {
        return GetCoinDescriptionUseCase(coinRepository)
    }

    @Provides
    fun provideGetCoinsUseCase(coinRepository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepository)
    }
}