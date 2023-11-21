package com.example.cryptocurrency.core.utils

sealed class UIEvent {
    data class ShowSnackBar(
        val message: String,
    ) : UIEvent()
}