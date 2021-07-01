package com.jan.melichallenge.domain.repository

import com.jan.melichallenge.base.BaseResultRepository
import com.jan.melichallenge.data.api.datasource.ProductRemoteDataSource
import com.jan.melichallenge.data.database.datasource.SearchLocalDataSource
import com.jan.melichallenge.domain.model.Product
import com.jan.melichallenge.domain.model.Search
import retrofit2.HttpException
import java.lang.Exception
import java.util.*

interface ProductRepository {

    suspend fun checkRequireNewPage(query: String, offset: Int): BaseResultRepository<List<Product>>
}

class ProductRepositoryImpl(
    private val searchLocalDataSource: SearchLocalDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    companion object {
        private const val PAGE_SIZE = 50
    }

    override suspend fun checkRequireNewPage(
        query: String, offset: Int
    ): BaseResultRepository<List<Product>> {
        searchLocalDataSource.insert(Search(0, query, Date().time))
        return if (offset % PAGE_SIZE == 0) {
            try {
                val products = productRemoteDataSource.searchProducts(query, offset)
                BaseResultRepository.Success(products)
            } catch (ex: Exception) {
                if (ex is HttpException) {
                    BaseResultRepository.NetworkError(ex)
                } else {
                    BaseResultRepository.Error(ex)
                }
            }
        } else {
            BaseResultRepository.Success(listOf())
        }
    }
}