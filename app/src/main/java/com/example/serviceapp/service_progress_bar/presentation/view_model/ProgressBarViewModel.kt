package com.example.serviceapp.service_progress_bar.presentation.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.serviceapp.service_progress_bar.domain.service.CustomService
import java.util.function.Consumer

class ProgressBarViewModel(private val service: CustomService?) : ViewModel() {
    val loadingIntStatus = MutableLiveData<Int>()

    private val loadingStatusConsumer = Consumer<Int> {
        Log.d("ServiceManage", "LoadingThread loadValue = $it")
        loadingIntStatus.value = it
    }

    fun startLoadingData() {
        Log.d("serviceManage", "click load 3 $service")
        service?.startLoadingThread(loadingStatusConsumer)
    }
}