package com.example.serviceapp.service_progress_bar.presentation.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.serviceapp.service_progress_bar.domain.service.CustomService

class ProgressBarViewModelFactory(private val service: CustomService?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.d("serviceManage", "click load 2 $service")
        return ProgressBarViewModel(service) as T
    }
}