package com.jan.melichallenge.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jan.melichallenge.R
import com.jan.melichallenge.data.api.MeliApiServices
import com.jan.melichallenge.data.api.datasource.ProductRemoteDataSourceImpl
import com.jan.melichallenge.data.product.ProductRemoteDataSource
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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

/**
 *  Returns a custom OkHttpClient instance with interceptor. Used for building Retrofit service
 */
fun createHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .readTimeout(60, TimeUnit.SECONDS)
    .connectTimeout(60, TimeUnit.SECONDS)
    .build()


/**
 *  function to build our Retrofit service
 *  @param baseUrl
 */
inline fun <reified T> createWebService(baseUrl: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(createHttpClient())
        .build()
    return retrofit.create(T::class.java)
}