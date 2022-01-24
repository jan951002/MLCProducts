package com.jan.melichallenge.data.product

import com.jan.melichallenge.domain.Error
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.domain.Result
import com.jan.melichallenge.testmanager.MainCoroutineRule
import com.jan.melichallenge.testmanager.product.productList
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

private const val QUERY_WITH_DATA = "Moto G6"
private const val QUERY_WITH_EMPTY_DATA = "DFKFDJJDFKDFLK"

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ProductRepositoryImplTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var productRepository: ProductRepositoryImpl

    @Test
    fun `search products that containing empty data`() = runBlockingTest {
        val expectResult = Result.Success((emptyList<Product>()))
        given(productRepository.searchProducts(QUERY_WITH_EMPTY_DATA, 1))
            .willReturn(expectResult)
        val result = productRepository.searchProducts(QUERY_WITH_EMPTY_DATA, 1)
        assertEquals(expectResult, result)
    }

    @Test
    fun `search products that containing data`() = runBlockingTest {
        val expectResult = Result.Success(productList)
        given(productRepository.searchProducts(QUERY_WITH_DATA, 1))
            .willReturn(expectResult)
        val result = productRepository.searchProducts(QUERY_WITH_DATA, 1)
        assertEquals(expectResult, result)
    }

    @Test
    fun `search products with network error`() = runBlockingTest {
        val expectResult = Result.Failure(Error.NetworkError("Network error"))
        given(productRepository.searchProducts(QUERY_WITH_DATA, 1))
            .willReturn(expectResult)
        val result = productRepository.searchProducts(QUERY_WITH_DATA, 1)
        assertEquals(expectResult, result)
    }

    @Test
    fun `search products with unknown error`() = runBlockingTest {
        val expectResult = Result.Failure(Error.UnknownError(Exception()))
        given(productRepository.searchProducts(QUERY_WITH_DATA, 1))
            .willReturn(expectResult)
        val result = productRepository.searchProducts(QUERY_WITH_DATA, 1)
        assertEquals(expectResult, result)
    }
}
