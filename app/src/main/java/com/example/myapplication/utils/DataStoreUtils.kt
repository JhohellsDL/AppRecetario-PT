package com.example.myapplication.utils

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = DATASTORE_NAME)

fun createDataStore(context: Context): androidx.datastore.core.DataStore<Preferences> {
    return context.dataStore
}
