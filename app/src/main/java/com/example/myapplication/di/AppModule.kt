package com.example.myapplication.di

import com.example.myapplication.data.DataStoreManager
import com.example.myapplication.ui.onboarding.OnboardingViewModel
import com.example.myapplication.utils.createDataStore
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dataStoreModule = module {
    single { DataStoreManager(get()) }
    single { createDataStore(get()) }
}
val viewModelModule = module {
    viewModelOf(::OnboardingViewModel)
}

val appModule = listOf(dataStoreModule, viewModelModule)
