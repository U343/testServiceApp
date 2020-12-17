package com.example.serviceapp.service_progress_bar.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.serviceapp.service_progress_bar.domain.service.CustomService

class ProgressBarViewModelFactory(private val service: CustomService?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProgressBarViewModel(service) as T
    }
}