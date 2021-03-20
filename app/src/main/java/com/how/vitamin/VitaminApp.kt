package com.how.vitamin

import android.app.Application
import com.how.vitamin.di.dataSourceModule
import com.how.vitamin.di.networkModule
import com.how.vitamin.di.repositoryModule
import com.how.vitamin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VitaminApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VitaminApp)
            modules(dataSourceModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(networkModule)
        }
    }

}