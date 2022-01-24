package com.jan.melichallenge.ui.product

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jan.melichallenge.domain.Error
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.domain.Result
import com.jan.melichallenge.testmanager.MainCoroutineRule
import com.jan.melichallenge.testmanager.product.productList
import com.jan.melichallenge.ui.product.list.ProductsViewModel
import com.jan.melichallenge.ui.product.list.SearchProductsState
import com.jan.melichallenge.usecases.product.ProductListUseCase
import com.jan.melichallenge.usecases.search.SaveSearchUseCase
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

private const val QUERY_WITH_DATA = "Moto G6"
private const val QUERY_WITH_EMPTY_DATA = "DFKFDJJDFKDFLK"

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ProductsViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var productListUseCase: ProductListUseCase

    @Mock
    private lateinit var saveSearchUseCase: SaveSearchUseCase

    private lateinit var productsViewModel: ProductsViewModel

    @Mock
    private lateinit var observer: Observer<SearchProductsState>

    @Before
    fun setup() {
        productsViewModel = ProductsViewModel(productListUseCase, saveSearchUseCase)
        productsViewModel.searchState.observeForever(observer)
    }

    @Test
    fun `search products with empty data`() = runBlockingTest {
        val expectResult = Result.Success((emptyList<Product>()))
        `when`(productListUseCase.invoke(QUERY_WITH_EMPTY_DATA, 1)).thenReturn(expectResult)

        productsViewModel.query = QUERY_WITH_EMPTY_DATA
        productsViewModel.searchProducts(true, 1)

        verify(observer).onChanged(SearchProductsState.LOADING)
        verify(observer).onChanged(SearchProductsState.NOT_FOUND)
    }

    @Test
    fun `search for products containing data`() = runBlockingTest {
        val expectResult = Result.Success((productList))
        `when`(productListUseCase.invoke(QUERY_WITH_DATA, 1)).thenReturn(expectResult)

        productsViewModel.query = QUERY_WITH_DATA
        productsViewModel.searchProducts(true, 1)

        verify(observer).onChanged(SearchProductsState.LOADING)
        verify(observer).onChanged(SearchProductsState.SEARCHED)
    }

    @Test
    fun `search products with network error`() = runBlockingTest {
        val expectResult = Result.Failure(Error.NetworkError("Network error"))
        given(productListUseCase.invoke(QUERY_WITH_DATA, 1)).willReturn(expectResult)

        productsViewModel.query = QUERY_WITH_DATA
        productsViewModel.searchProducts(true, 1)

        verify(observer).onChanged(SearchProductsState.LOADING)
        verify(observer).onChanged(SearchProductsState.NETWORK_ERROR)
    }

    @Test
    fun `search products with unknown error`() = runBlockingTest {
        val expectResult = Result.Failure(Error.UnknownError(Exception()))
        given(productListUseCase.invoke(QUERY_WITH_DATA, 1)).willReturn(expectResult)

        productsViewModel.query = QUERY_WITH_DATA
        productsViewModel.searchProducts(true, 1)

        verify(observer).onChanged(SearchProductsState.LOADING)
        verify(observer).onChanged(SearchProductsState.GENERAL_ERROR)
    }
}
