package com.example.serviceapp.service_progress_bar.domain.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.example.serviceapp.service_progress_bar.domain.view.LoadingThread
import java.util.*
import java.util.function.Consumer
import kotlin.random.Random

class CustomService : Service() {
    private val stopServiceConsumer = Consumer<Int> { startId -> stopSelf(startId) }

    private val binder = CustomBinder()
    private var serviceId: Int = 0
    private lateinit var looperThread: LoadingThread

    override fun onBind(intent: Intent?): IBinder {
        Log.d("ServiceManage", "Service bind ${Thread.currentThread().name}")
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("ServiceManage", "Service unbind ${Thread.currentThread().name}")

        return super.onUnbind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        serviceId = startId

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

    fun startLoadingThread(workConsumer: Consumer<Int>) {
        Log.d("ServiceManage", "into startLoadingThread")
        looperThread = LoadingThread(stopServiceConsumer, workConsumer, serviceId)
        looperThread.start()
    }

    fun getRandomNum(): Int {
        return Random.nextInt(100)
    }

    inner class CustomBinder : Binder() {
        fun getService(): CustomService = this@CustomService
    }
}