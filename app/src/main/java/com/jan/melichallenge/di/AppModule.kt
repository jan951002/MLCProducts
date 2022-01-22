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

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Named("meliApiBaseUrl")
    fun meliApiBaseUrlProvider(app: Application) = app.getString(R.string.meli_api_base_url)

    @Provides
    @Singleton
    fun meliApiServicesProvider(@Named("meliApiBaseUrl") meliApiBaseUrl: String) =
        createWebService<MeliApiServices>(meliApiBaseUrl)

    @Provides
    @Singleton
    fun meliDatabaseProvider(app: Application) = provideMeliDatabase(app)
}