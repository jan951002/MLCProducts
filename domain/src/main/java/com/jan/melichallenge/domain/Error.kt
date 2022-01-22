package com.jan.melichallenge.domain

sealed class Error<out N, out U> {
    data class NetworkError<out N>(val reason: N?) : Error<N, Nothing>()
    data class UnknownError<out U>(val reason: U?) : Error<Nothing, U>()
}
