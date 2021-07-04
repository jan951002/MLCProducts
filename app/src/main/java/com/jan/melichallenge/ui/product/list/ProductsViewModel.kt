package com.jan.melichallenge.ui.product.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jan.melichallenge.base.BaseUseCaseResult
import com.jan.melichallenge.domain.model.Product
import com.jan.melichallenge.usecase.ProductListUseCase
import com.jan.melichallenge.usecase.SaveSearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductsViewModel(
    application: Application,
    private val productListUseCase: ProductListUseCase,
    private val saveSearchUseCase: SaveSearchUseCase
) : AndroidViewModel(application) {

    var query = ""
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error
    private val _info = MutableLiveData<String>()
    val info: LiveData<String> get() = _info
    val offset = MutableStateFlow(0)

    init {
        viewModelScope.launch {
            offset.collect { findProducts(offset = it) }
        }
    }

    suspend fun findProducts(isNewQuery: Boolean = false, offset: Int) {
        when (val result = productListUseCase.invoke(query, offset)) {
            is BaseUseCaseResult.Success -> {
                result.data?.let { productList ->
                    if (isNewQuery) {
                        saveSearchUseCase.invoke(query)
                        _products.value = productList
                    } else {
                        val newList = products.value?.toMutableList()
                        newList?.addAll(productList)
                        _products.value = newList?.toList()
                    }
                }
            }

            is BaseUseCaseResult.Error -> {
            }

            is BaseUseCaseResult.NetworkError -> {
            }
        }
    }
}