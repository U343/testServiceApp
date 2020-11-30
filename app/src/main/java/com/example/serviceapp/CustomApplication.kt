package com.example.serviceapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class CustomApplication : Application() {
    companion object {
        const val CHANEL_ID = "exampleServiceChanel"
    }

    override fun onCreate() {
        super.onCreate()

        createNotificationChanel()
    }

    private fun createNotificationChanel() {
        val serviceChanel: NotificationChannel
        val manager: NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            serviceChanel = NotificationChannel(
                CHANEL_ID,
                "Example,Service Chanel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChanel)
        }
    }
}