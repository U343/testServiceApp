package com.example.serviceapp.broadcast_test.presentation.view

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.serviceapp.R
import com.example.serviceapp.broadcast_test.domain.broadcast_receiver.CustomReceiver

class BroadcastActivity : AppCompatActivity() {
    private val receiver = CustomReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        registerMyReceiver()
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

    private fun registerMyReceiver() {
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }
        registerReceiver(receiver, intentFilter)
    }
}