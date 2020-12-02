package com.example.serviceapp.broadcast_receiver.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.serviceapp.R

class PhoneInfoFragment : Fragment() {
    companion object {
        const val TAG = "PhoneInfoFragment"

        fun newInstance() : Fragment {
            return PhoneInfoFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.broadcast_receiver_fragment, container, false)
    }
}