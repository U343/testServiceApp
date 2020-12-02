package com.example.serviceapp.start_activity.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.serviceapp.R
import com.example.serviceapp.broadcast_receiver_example.presentation.view.PhoneInfoActivity
import com.example.serviceapp.cat_facts.presentation.view.CatFactsActivity
import com.example.serviceapp.start_activity.presentation.router.StartActivityRouter
import kotlinx.android.synthetic.main.start_activity.*

class StartActivity : AppCompatActivity(), StartActivityRouter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)

        Log.d("fragmentLifecycle", "StartActivity")

        start_cats_facts_button.setOnClickListener { goToCatFacts() }
        start_phone_info_button.setOnClickListener { goToPhoneInfo() }
    }

    override fun goToCatFacts() {
        startActivity(Intent(this, CatFactsActivity::class.java))
    }

    override fun goToPhoneInfo() {
        startActivity(Intent(this, PhoneInfoActivity::class.java))
    }


}