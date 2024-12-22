package com.example.myapplication.di

import androidx.room.Room
import com.example.myapplication.data.datasource.RecetaLocalDataSource
import com.example.myapplication.data.datasource.RecetaRemoteDataSource
import com.example.myapplication.data.datastore.DataStoreManager
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.data.remote.RecetaApi
import com.example.myapplication.domain.repository.RecetaRepository
import com.example.myapplication.domain.usecase.GetRecetasFavoritasIdsUseCase
import com.example.myapplication.domain.usecase.GetRecetasFavoritasUseCase
import com.example.myapplication.domain.usecase.GetRecetasUseCase
import com.example.myapplication.domain.usecase.SaveRecetasFavoritasUseCase
import com.example.myapplication.ui.home.FavoritesViewModel
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.ui.home.RecetasViewModel
import com.example.myapplication.ui.onboarding.OnboardingViewModel
import com.example.myapplication.utils.createDataStore
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataStoreModule = module {
    single { DataStoreManager(get()) }
    single { createDataStore(get()) }
}

val repositoryModule = module {
    single<RecetaLocalDataSource> { RecetaLocalDataSource(get()) }
    single<RecetaRemoteDataSource> { RecetaRemoteDataSource(get()) }
    single { RecetaRepository(get(), get()) }
}

val useCaseModule = module {
    factory { GetRecetasUseCase(get()) }
    factory { SaveRecetasFavoritasUseCase(get()) }
    factory { GetRecetasFavoritasUseCase(get()) }
    factory { GetRecetasFavoritasIdsUseCase(get()) }
}

val viewModelModule = module {
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::RecetasViewModel)
    viewModelOf(::FavoritesViewModel)
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

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://51df8ff3-a1b3-44d8-9155-637c190cff82.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<RecetaApi> {
        get<Retrofit>().create(RecetaApi::class.java)
    }
}

val appModule =
    listOf(
        dataStoreModule,
        viewModelModule,
        repositoryModule,
        useCaseModule,
        databaseModule,
        networkModule
    )
