package com.example.serviceapp.service_progress_bar.domain.service

import android.app.Service

object CustomServiceFactory {
    private var instance: Service? = null

    fun getCustomService(): Service? {
        if (instance == null) {
            instance = CustomService()
        }
        return instance
    }
}