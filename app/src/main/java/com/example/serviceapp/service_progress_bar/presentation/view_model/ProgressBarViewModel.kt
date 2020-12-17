package com.example.serviceapp.service_progress_bar.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.serviceapp.service_progress_bar.domain.service.CustomService
import java.util.function.Consumer

class ProgressBarViewModel(service: CustomService?) : ViewModel() {
    val loadingIntStatus = MutableLiveData<Int>()

    private val loadingStatusConsumer = Consumer<Int> { loadingIntStatus.value = it }

    fun startLoadingData() {

    }
}