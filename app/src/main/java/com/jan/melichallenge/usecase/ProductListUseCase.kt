package com.jan.melichallenge.usecase

import com.jan.melichallenge.base.BaseUseCaseResult
import com.jan.melichallenge.domain.repository.ProductRepository
import retrofit2.HttpException

class ProductListUseCase(private val productRepository: ProductRepository) {

    suspend fun invoke(query: String, offset: Int) = try {
        BaseUseCaseResult.Success(productRepository.checkRequireNewPage(query, offset))
    } catch (ex: Exception) {
        if (ex is HttpException)
            BaseUseCaseResult.NetworkError(ex)
        else
            BaseUseCaseResult.Error(ex)
    }
}