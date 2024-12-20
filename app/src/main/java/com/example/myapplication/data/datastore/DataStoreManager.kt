package com.example.myapplication.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreManager(private val dataStore: DataStore<Preferences>) {

    companion object {
        private val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }

    val onboardingCompletedFlow: Flow<Boolean> = dataStore.data
        .map { it[ONBOARDING_COMPLETED] == true }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        try {
            dataStore.edit {
                if (it[ONBOARDING_COMPLETED]?.equals(completed) != true) {
                    it[ONBOARDING_COMPLETED] = completed
                }
            }
        } catch (e: IOException){
            throw IOException("Error al guardar el estado del onboarding", e)
        }
    }
}