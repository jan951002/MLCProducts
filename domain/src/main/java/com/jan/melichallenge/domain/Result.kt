package com.jan.melichallenge.domain

sealed class Result<out T, out E> {
    data class Success<out T>(val data: T?) : Result<T, Nothing>()
    data class Failure<out E>(val reason: E?) : Result<Nothing, E>()
}
