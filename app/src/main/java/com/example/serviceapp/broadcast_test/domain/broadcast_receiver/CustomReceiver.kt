package com.example.serviceapp.broadcast_test.domain.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        intent?.action?.let { intentAction ->
            val toastMessage = when (intentAction) {
                Intent.ACTION_POWER_CONNECTED -> "Power connected!"
                Intent.ACTION_POWER_DISCONNECTED -> "Power disconnected!"
                else -> "Unknown receive"
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
