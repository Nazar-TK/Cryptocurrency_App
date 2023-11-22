package com.example.cryptocurrency.presentation.coin_details

import com.example.cryptocurrency.domain.model.CoinDetails

class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
) {

}