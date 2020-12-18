package com.example.serviceapp.service_progress_bar.domain.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.example.serviceapp.service_progress_bar.domain.view.LoadingThread
import java.util.*
import java.util.function.Consumer

class CustomService : Service() {
    private val stopServiceConsumer = Consumer<Int> { startId -> stopSelf(startId) }
    private val binder = CustomBinder()

    override fun onBind(intent: Intent?): IBinder {
        Log.d("ServiceManage", "Service bind ${Thread.currentThread().name}")
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("ServiceManage", "Service unbind ${Thread.currentThread().name}")

        return super.onUnbind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        LoadingThread(stopServiceConsumer, startId).start()
        Log.d("ServiceManage", "Service start")
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

    fun stopService() {
        stopSelf()
    }

    fun getRandomNum(): Int {
        stopService()
        return Random().nextInt(100)
    }

    inner class CustomBinder : Binder() {
        fun getService(): CustomService = this@CustomService
    }
}