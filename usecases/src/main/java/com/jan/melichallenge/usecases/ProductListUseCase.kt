package com.jan.melichallenge.usecases

import com.jan.melichallenge.data.product.ProductRepository
import retrofit2.HttpException

class ProductListUseCase(private val productRepository: ProductRepository) {

    suspend fun invoke(query: String, offset: Int) = try {
        BaseUseCaseResult.Success(productRepository.searchProducts(query, offset))
    } catch (ex: Exception) {
        if (ex is HttpException)
            BaseUseCaseResult.NetworkError(ex)
        else
            BaseUseCaseResult.Error(ex)
    }
}