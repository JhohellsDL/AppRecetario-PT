package com.example.myapplication.di

import androidx.room.Room
import com.example.myapplication.data.datasource.RecetaDataSource
import com.example.myapplication.data.datastore.DataStoreManager
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.repository.RecetaRepository
import com.example.myapplication.domain.usecase.GetRecetasFavoritasUseCase
import com.example.myapplication.domain.usecase.GetRecetasUseCase
import com.example.myapplication.domain.usecase.SaveRecetasFavoritasUseCase
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.ui.onboarding.OnboardingViewModel
import com.example.myapplication.utils.createDataStore
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dataStoreModule = module {
    single { DataStoreManager(get()) }
    single { createDataStore(get()) }
}

val repositoryModule = module {
    single<RecetaDataSource> { RecetaDataSource(get()) }
    single { RecetaRepository(get()) }
}

val useCaseModule = module {
    factory { GetRecetasUseCase(get()) }
    factory { SaveRecetasFavoritasUseCase(get()) }
    factory { GetRecetasFavoritasUseCase(get()) }
}

val viewModelModule = module {
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::HomeViewModel)
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single { get<AppDatabase>().favoriteRecipeDao() }
}

val appModule = listOf(dataStoreModule, viewModelModule, repositoryModule, useCaseModule, databaseModule)
