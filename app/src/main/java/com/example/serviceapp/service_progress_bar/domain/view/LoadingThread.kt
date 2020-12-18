package com.example.serviceapp.service_progress_bar.domain.view

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.function.Consumer
import kotlin.random.Random

class LoadingThread(private val stopService: Consumer<Int>,
                    private val loadingStatusConsumer: Consumer<Int>,
                    private val processId: Int) : Thread() {

    private val CHANGE_LOADING_VALUE = 1
    private val FINAL_LOADING_VALUE = 100


    @RequiresApi(Build.VERSION_CODES.N)
    override fun run() {
        super.run()
        var loadValue = 0


        Log.d("ServiceManage", "LoadingThread run")

        while (loadValue <= FINAL_LOADING_VALUE) {

            loadValue += CHANGE_LOADING_VALUE
            loadingStatusConsumer.accept(loadValue)
            sleep(Random.nextLong(200, 4000))

        }
        Log.d("ServiceManage", "LoadingThread stop thread")
        stopService.accept(processId)

    }
}