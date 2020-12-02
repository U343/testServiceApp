package com.example.serviceapp.broadcast_receiver_example.domain.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class MyBroadcastReceiver : BroadcastReceiver() {
    val data = MutableLiveData<String>()

    override fun onReceive(context: Context, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also { log ->
                Log.d("MyBroadcastReceiver", log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
        data.value = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0).toString()
    }
}