package com.example.cryptocurrency.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.core.utils.Constants
import com.example.cryptocurrency.core.utils.Resource
import com.example.cryptocurrency.domain.use_case.get_coin.GetCoinDescriptionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDescriptionUseCase: GetCoinDescriptionUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel( ){

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }
    private fun getCoin(coinId: String){
        getCoinDescriptionUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coinDetails = result.data)
                } is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                } is Resource.Error -> {
                    _state.value = CoinDetailsState(error = result.message ?: "An unexpected error occurred.")
                }
            }
        }.launchIn(viewModelScope)
    }
}