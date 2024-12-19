package com.example.myapplication.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.DataStoreManager
import kotlinx.coroutines.launch

class OnboardingViewModel (
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    val onboardingCompleted = dataStoreManager.onboardingCompletedFlow

    fun setOnboardingCompleted() {
        viewModelScope.launch {
            dataStoreManager.setOnboardingCompleted(true)
        }
    }
}
