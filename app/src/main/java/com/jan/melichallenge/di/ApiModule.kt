package com.jan.melichallenge.di

import android.content.Context
import com.jan.melichallenge.R
import com.jan.melichallenge.apimanager.MeliApiServices
import com.jan.melichallenge.apimanager.createWebService
import com.jan.melichallenge.apimanager.product.ProductRemoteDataSourceImpl
import com.jan.melichallenge.data.product.ProductRemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Module to configure api dependency injection
 * @author Jaime Trujillo
 */

val apiModule = module {

    single { provideMeliApiServices(androidContext()) }

    single { provideProductRemoteDataSource(meliApiServices = get()) }
}

/**
 *  function to build our MeliApiServices
 *  @param context
 */
fun provideMeliApiServices(context: Context) =
    createWebService<MeliApiServices>(context.getString(R.string.meli_api_base_url))

/**
 *  function to build our ProductRemoteDataSource
 *  @param meliApiServices
 */
fun provideProductRemoteDataSource(meliApiServices: MeliApiServices): ProductRemoteDataSource =
    ProductRemoteDataSourceImpl(meliApiServices)