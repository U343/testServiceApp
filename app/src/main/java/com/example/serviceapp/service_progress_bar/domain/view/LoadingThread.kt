package com.example.serviceapp.service_progress_bar.domain.view

import android.os.Build
import android.os.Looper
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.function.Consumer
import java.util.logging.Handler

class LoadingThread(private val stopParentService: Consumer<Int>, private val processId: Int) : Thread() {
    lateinit var handler: Handler

    @RequiresApi(Build.VERSION_CODES.N)
    override fun run() {
        super.run()

        Log.d("ServiceManage", "LoadingThread ${currentThread().name}")
        sleep(2000)
        stopParentService.accept(processId)
    }
}