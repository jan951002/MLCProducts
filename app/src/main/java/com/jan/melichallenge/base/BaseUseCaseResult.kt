package com.jan.melichallenge.base

import retrofit2.HttpException

/**
 * This will be useful to get the data if the request was successful or get the exception if our request failed
 * @author Jaime Trujillo
 */
sealed class BaseUseCaseResult<out T : Any> {
    class Success<out T : Any>(val data: T?) : BaseUseCaseResult<T>()
    class Error(val exception: Throwable) : BaseUseCaseResult<Nothing>()
    class NetworkError(val exception: HttpException) : BaseUseCaseResult<Nothing>()
}