package com.example.serviceapp.service_progress_bar.domain.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.serviceapp.service_progress_bar.domain.view.LoadingThread
import java.util.function.Consumer

class CustomService : Service() {
    private val stopServiceConsumer = Consumer<Int> { startId -> stopSelf(startId) }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        LoadingThread(stopServiceConsumer, startId).start()
        return START_NOT_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("ServiceManage", "Service create ${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ServiceManage", "Service destroy ${Thread.currentThread().name}")
    }
}