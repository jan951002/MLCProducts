package com.jan.melichallenge.apimanager

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jan.melichallenge.apimanager.product.SearchProductsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 *  This interface contains the MELI API endpoints
 *  @author Jaime Trujillo
 */
interface MeliApiServices {

    @GET("search")
    suspend fun searchProducts(
        @Query("q") query: String, @Query("offset") offset: Int
    ): SearchProductsResponse
}

/**
 *  Returns a custom OkHttpClient instance with interceptor. Used for building Retrofit service
 *  @author Jaime Trujillo
 */
fun createHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .readTimeout(60, TimeUnit.SECONDS)
    .connectTimeout(60, TimeUnit.SECONDS)
    .build()


/**
 *  function to build our Retrofit service
 *  @param baseUrl
 *  @author Jaime Trujillo
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