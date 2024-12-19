package com.example.myapplication.ui.app

import android.app.Application
import com.example.myapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RecetasApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@RecetasApp)
            modules(appModule)
        }
    }
}