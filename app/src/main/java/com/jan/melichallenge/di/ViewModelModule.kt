package com.jan.melichallenge.di

import android.app.Application
import com.jan.melichallenge.domain.repository.SearchRepository
import com.jan.melichallenge.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module to configure view models dependency injection
 * @author Jaime Trujillo
 */

val viewModelModule = module {

    viewModel { provideMainViewModel(application = androidApplication(), searchRepository = get()) }
}

/**
 *  function to build our MainViewModel
 *  @param application
 *  @param searchRepository
 */
fun provideMainViewModel(application: Application, searchRepository: SearchRepository) =
    MainViewModel(application, searchRepository)