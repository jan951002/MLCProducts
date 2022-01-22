package com.jan.melichallenge.ui.product.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jan.melichallenge.domain.Error
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.domain.Result
import com.jan.melichallenge.usecases.product.ProductListUseCase
import com.jan.melichallenge.usecases.search.SaveSearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductsViewModel(
    application: Application,
    private val productListUseCase: ProductListUseCase,
    private val saveSearchUseCase: SaveSearchUseCase
) : AndroidViewModel(application) {

    companion object {
        const val NEW_SEARCH = 0
        const val SEARCHED = 1
        const val NOT_FOUND = 2
        const val GENERAL_ERROR = 3
        const val NETWORK_ERROR = 4
        const val LOADING = 5
    }

    var query = ""
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products
    private val _searchState = MutableLiveData<Int>().apply { value = NEW_SEARCH }
    val searchState: LiveData<Int> get() = _searchState
    val offset = MutableStateFlow(0)

    init {
        viewModelScope.launch {
            offset.collect { if (it != 0) searchProducts(offset = it) }
        }
    }

    suspend fun searchProducts(isNewQuery: Boolean = false, offset: Int) {
        if (isNewQuery)
            _searchState.value = LOADING
        when (val result = productListUseCase.invoke(query, offset)) {
            is Result.Success -> {
                result.data?.let { productList ->
                    if (isNewQuery) {
                        if (productList.isNotEmpty()) {
                            _searchState.value = SEARCHED
                            saveSearchUseCase.invoke(query)
                            _products.value = productList
                        } else {
                            _searchState.value = NOT_FOUND
                        }
                    } else {
                        val newList = products.value?.toMutableList()
                        newList?.addAll(productList)
                        _products.value = newList?.toList()
                    }
                }
            }

            is Result.Failure -> {
                if (isNewQuery) {
                    if (result.reason is Error.UnknownError)
                        _searchState.value = GENERAL_ERROR
                    else
                        _searchState.value = NETWORK_ERROR
                }
            }
        }
    }
}