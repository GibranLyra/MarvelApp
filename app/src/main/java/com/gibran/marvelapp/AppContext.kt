package com.gibran.marvelapp

import android.app.Application
import com.gibran.marvelservice.di.NetworkModule
import com.gibran.marvelapp.di.AppComponent
import com.gibran.marvelservice.di.HeroServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

@Suppress("EXPERIMENTAL_API_USAGE")
class AppContext : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        //I would do a check to plant the DebugTree only if the BuildType is Debug
        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@AppContext)
            androidLogger()
            modules(
                AppComponent.viewModelModule,
                AppComponent.useCaseModule,
                HeroServiceModule.dataSourceModule,
                HeroServiceModule.repositoryModule,
                NetworkModule.networkModule
            )
        }
    }

    companion object {
        lateinit var instance: AppContext private set
    }
}
