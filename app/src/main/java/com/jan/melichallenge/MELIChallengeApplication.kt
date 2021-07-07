package com.jan.melichallenge

import android.app.Application
import com.jan.melichallenge.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 * @author Jaime Trujillo
 */
class MELIChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /* Adding Koin modules to our application */
        startKoin {
            androidContext(this@MELIChallengeApplication)
            modules(
                apiModule,
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}