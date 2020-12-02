package com.example.serviceapp.broadcast_receiver_example.presentation.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import com.example.serviceapp.broadcast_receiver_example.domain.broadcast_receiver.MyBroadcastReceiver
import kotlinx.android.synthetic.main.broadcast_receiver_fragment.*

class PhoneInfoFragment : Fragment() {
    lateinit var br: MyBroadcastReceiver

    companion object {
        const val TAG_FRAGMENT = "PhoneInfoFragment"

        fun newInstance() : Fragment {
            return PhoneInfoFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        registerBroadcastReceiver()
    }

    override fun onDetach() {
        super.onDetach()

        requireActivity().unregisterReceiver(br)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.broadcast_receiver_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        br.data.observe(this) { receiver_battery_info.text = it }
    }

    private fun registerBroadcastReceiver() {
        br = MyBroadcastReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        requireActivity().registerReceiver(br, filter)
    }
}