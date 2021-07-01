package com.jan.melichallenge.base

import android.app.Application
import com.jan.melichallenge.di.apiModule
import com.jan.melichallenge.di.databaseModule
import com.jan.melichallenge.di.repositoryModule
import com.jan.melichallenge.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 * @author Jaime Trujillo
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /* Adding Koin modules to our application */
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                apiModule,
                databaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}