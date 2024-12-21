package com.example.myapplication.ui.app

import android.app.Application
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RecetasApp: Application() {

    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = AppDatabase.getInstance(this)
        startKoin{
            androidContext(this@RecetasApp)
            modules(appModule)
        }
    }
}