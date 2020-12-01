package com.example.serviceapp.cat_facts.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import com.example.serviceapp.cat_facts.presentation.router.CatsFactRouter

class CatFactsActivity : AppCompatActivity(), CatsFactRouter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.empty_activity)

        Log.d("fragmentLifecycle", "CatFactsActivity")
        if (savedInstanceState == null)
            goToCatsFactPage()
    }

    override fun goToCatsFactPage() {
        showFragment(CatsFactFragment.newInstance(), false, CatsFactFragment.TAG)
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