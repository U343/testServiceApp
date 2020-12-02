package com.example.serviceapp.broadcast_receiver.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import com.example.serviceapp.broadcast_receiver.presentation.router.BroadcastRouter

class ReceiverActivity : AppCompatActivity(), BroadcastRouter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.empty_activity)

        goToPhoneInfoFragment()
    }

    override fun goToPhoneInfoFragment() {
        showFragment(PhoneInfoFragment.newInstance(), false, PhoneInfoFragment.TAG)
    }

    private fun showFragment(fragment: Fragment, toBackStack: Boolean, tag: String) {
        val fragmentManager = supportFragmentManager

        val fragmentTransaction = fragmentManager.beginTransaction()
        val newFragment = fragmentManager.findFragmentByTag(tag) ?: fragment
        fragmentTransaction.replace(android.R.id.content, newFragment, tag)
        if (toBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }
}