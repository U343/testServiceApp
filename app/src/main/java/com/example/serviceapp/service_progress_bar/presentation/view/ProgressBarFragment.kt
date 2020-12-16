package com.example.serviceapp.service_progress_bar.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import kotlinx.android.synthetic.main.service_progress_bar_fragment.*

class ProgressBarFragment: Fragment() {

    companion object {
        const val TAG = "ProgressBarFragment"

        fun newInstance(): ProgressBarFragment {
            return ProgressBarFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("fragmentLifecycle", "ProgressBarFragment")
        return inflater.inflate(R.layout.service_progress_bar_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service_start_progress_button.setOnClickListener { startProgressBar() }
    }

    private fun startProgressBar() {
        for (i in 10..100) {
            service_progress_bar.progress = i
        }
    }
}