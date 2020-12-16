package com.example.serviceapp.service_progress_bar.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import com.example.serviceapp.service_progress_bar.presentation.router.ServiceProgressRouter

class ServiceProgressActivity : AppCompatActivity(), ServiceProgressRouter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.empty_activity)
        Log.d("fragmentLifecycle", "ServiceProgressActivity")

        if (savedInstanceState == null) {
            goToProgressBarFragment()
        }
    }

    override fun goToProgressBarFragment() {
        showFragment(ProgressBarFragment.newInstance(), false, ProgressBarFragment.TAG)
    }

    private fun showFragment(fragment: Fragment, toBackStack: Boolean, tag: String) {
        val fragmentManager = supportFragmentManager


        Log.d("fragmentLifecycle", "ServiceProgressActivity showFragment")
        val fragmentTransaction = fragmentManager.beginTransaction()
        val newFragment = fragmentManager.findFragmentByTag(tag) ?: fragment
        fragmentTransaction.replace(android.R.id.content, newFragment, tag)
        if (toBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }
}