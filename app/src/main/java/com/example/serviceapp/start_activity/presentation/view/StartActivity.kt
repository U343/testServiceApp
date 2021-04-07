package com.example.serviceapp.start_activity.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.serviceapp.R
import com.example.serviceapp.broadcast_test.presentation.view.BroadcastActivity
import com.example.serviceapp.view_pager_example.presentation.view.StartPagerActivity
import com.example.serviceapp.cat_facts.presentation.view.CatFactsActivity
import com.example.serviceapp.coordinator.presentation.view.CoordinatorActivity
import com.example.serviceapp.service_progress_bar.presentation.view.ServiceProgressActivity
import com.example.serviceapp.start_activity.presentation.router.StartActivityRouter
import kotlinx.android.synthetic.main.start_activity.*

class StartActivity : AppCompatActivity(), StartActivityRouter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)

        Log.d("fragmentLifecycle", "StartActivity")

        start_cats_facts_button.setOnClickListener { goToCatFacts() }
        start_phone_info_button.setOnClickListener { goToPhoneInfo() }
        start_service_progress_button.setOnClickListener { goToServiceProgress() }
        start_coordinator_activity_button.setOnClickListener { goToCoordinatorActivity() }
        start_broadcast_activity_button.setOnClickListener { goToBroadCastReceiver() }
    }

    override fun goToCatFacts() {
        startActivity(Intent(this, CatFactsActivity::class.java))
    }

    override fun goToPhoneInfo() {
        startActivity(Intent(this, StartPagerActivity::class.java))
    }

    override fun goToServiceProgress() {
        startActivity(Intent(this, ServiceProgressActivity::class.java))
    }

    override fun goToCoordinatorActivity() {
        startActivity(Intent(this, CoordinatorActivity::class.java))
    }

    override fun goToBroadCastReceiver() {
        startActivity(Intent(this, BroadcastActivity::class.java))
    }
}