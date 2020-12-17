package com.example.serviceapp.service_progress_bar.presentation.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.serviceapp.R
import com.example.serviceapp.service_progress_bar.domain.service.CustomService
import com.example.serviceapp.service_progress_bar.domain.service.CustomServiceFactory
import com.example.serviceapp.service_progress_bar.presentation.view_model.ProgressBarViewModel
import com.example.serviceapp.service_progress_bar.presentation.view_model.ProgressBarViewModelFactory
import kotlinx.android.synthetic.main.service_progress_bar_fragment.*
import kotlinx.android.synthetic.main.start_activity.*

class ProgressBarFragment: Fragment() {
    private var service: CustomService? = null
    private lateinit var viewModel: ProgressBarViewModel

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

        initViewModel()
        val intent = Intent(requireActivity(), CustomService::class.java)

        service_start_progress_button.setOnClickListener {
            requireActivity().startService(intent)
        }
    }

   private fun initViewModel() {
       service = CustomServiceFactory.getCustomService()
       viewModel = ViewModelProvider(this, ProgressBarViewModelFactory(service)).get(ProgressBarViewModel::class.java)
   }
}