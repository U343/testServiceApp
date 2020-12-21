package com.example.serviceapp.service_progress_bar.presentation.view

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.serviceapp.R
import com.example.serviceapp.service_progress_bar.domain.service.CustomService
import com.example.serviceapp.service_progress_bar.presentation.view_model.ProgressBarViewModel
import com.example.serviceapp.service_progress_bar.presentation.view_model.ProgressBarViewModelFactory
import kotlinx.android.synthetic.main.service_progress_bar_fragment.*

class ProgressBarFragment: Fragment() {
    private var mService: CustomService? = null
    private var mBound: Boolean = false
    private lateinit var viewModel: ProgressBarViewModel

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as CustomService.CustomBinder
            mService = binder.getService()
            mBound = true
            initViewModel()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }
    }

    companion object {
        const val TAG = "ProgressBarFragment"

        fun newInstance(): ProgressBarFragment {
            return ProgressBarFragment()
        }
    }

    override fun onStop() {
        super.onStop()
        mBound = false
        requireActivity().unbindService(connection)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (!isMyServiceRunning()) {
            val intent = Intent(requireActivity(), CustomService::class.java)
            requireActivity().startService(intent)
        }
        Log.d("serviceManage", "onCreateView")
        Intent(requireActivity(), CustomService::class.java).also { intentBind ->
            requireActivity().bindService(intentBind, connection, Context.BIND_AUTO_CREATE)
        }

        return inflater.inflate(R.layout.service_progress_bar_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service_start_progress_button.setOnClickListener {
            viewModel.startLoadingData()
            Log.d("serviceManage", "click generate $mService")
            //service_text_view_progress.text = mService?.getRandomNum().toString()
        }
    }

   private fun initViewModel() {
       viewModel = ViewModelProvider(this, ProgressBarViewModelFactory(mService)).get(ProgressBarViewModel::class.java)

       viewModel.loadingIntStatus.observe(this) { progress ->
           service_progress_bar.progress = progress
           service_text_view_progress.text = progress.toString()
       }
   }

    private fun isMyServiceRunning(): Boolean {

        val manager: ActivityManager = requireActivity().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (CustomService::class.java.name == service.service.className) {
                return true;
            }
        }
        return false;
    }
}