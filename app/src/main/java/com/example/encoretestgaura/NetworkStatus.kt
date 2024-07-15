package com.example.encoretestgaura

sealed class NetworkStatus<T> {
    data class Success<T>(val data: T) : NetworkStatus<T>()
    data class Error<T>(val message: String) : NetworkStatus<T>()
    object Loading : NetworkStatus<Nothing>()
}