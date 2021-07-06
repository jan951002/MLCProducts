package com.jan.melichallenge.di

import android.app.Application
import com.jan.melichallenge.ui.main.MainViewModel
import com.jan.melichallenge.ui.product.list.ProductsViewModel
import com.jan.melichallenge.usecase.ProductListUseCase
import com.jan.melichallenge.usecase.SaveSearchUseCase
import com.jan.melichallenge.usecase.SearchListUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module to configure view models dependency injection
 * @author Jaime Trujillo
 */

val viewModelModule = module {

    viewModel {
        provideMainViewModel(
            application = androidApplication(), searchListUseCase = get()
        )
    }

    viewModel {
        provideProductsViewModel(
            androidApplication(), productListUseCase = get(), saveSearchUseCase = get()
        )
    }
}

/**
 *  function to build our MainViewModel
 *  @param application
 *  @param searchListUseCase
 */
fun provideMainViewModel(application: Application, searchListUseCase: SearchListUseCase) =
    MainViewModel(application, searchListUseCase)


/**
 *  function to build our ProductsViewModel
 *  @param application
 *  @param productListUseCase
 *  @param saveSearchUseCase
 */
fun provideProductsViewModel(
    application: Application,
    productListUseCase: ProductListUseCase,
    saveSearchUseCase: SaveSearchUseCase
) =
    ProductsViewModel(application, productListUseCase, saveSearchUseCase)