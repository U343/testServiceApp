package com.example.serviceapp.broadcast_receiver_example.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import com.example.serviceapp.broadcast_receiver_example.presentation.router.PhoneInfoRouter

class PhoneInfoActivity : AppCompatActivity(), PhoneInfoRouter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.empty_activity)

        goToPhoneInfoFragment()
    }

    override fun goToPhoneInfoFragment() {
        showFragment(PhoneInfoFragment.newInstance(), false, PhoneInfoFragment.TAG_FRAGMENT)
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