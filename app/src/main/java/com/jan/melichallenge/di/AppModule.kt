package com.jan.melichallenge.di

import android.app.Application
import com.jan.melichallenge.R
import com.jan.melichallenge.apimanager.MeliApiServices
import com.jan.melichallenge.apimanager.createWebService
import com.jan.melichallenge.databasemanager.provideMeliDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

/**
 *  Module to define general dependencies with Hilt library
 *  @author Jaime Trujillo
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    /**
     *  Function to provide a singleton instance of the MELI API base URL
     *  @param app To get a string resource
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    @Named("meliApiBaseUrl")
    fun meliApiBaseUrlProvider(app: Application) = app.getString(R.string.meli_api_base_url)

    /**
     *  Function to provide a singleton instance of the MELI API services
     *  @param meliApiBaseUrl URL to create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    fun meliApiServicesProvider(@Named("meliApiBaseUrl") meliApiBaseUrl: String) =
        createWebService<MeliApiServices>(meliApiBaseUrl)

    /**
     *  Function to provide a singleton instance of the MELI database
     *  @param app Require to create a MELI database instance
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    fun meliDatabaseProvider(app: Application) = provideMeliDatabase(app)
}