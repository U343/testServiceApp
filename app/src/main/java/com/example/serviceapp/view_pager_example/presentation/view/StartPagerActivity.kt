package com.example.serviceapp.view_pager_example.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import com.example.serviceapp.view_pager_example.presentation.adapter.StartActivityViewPagerAdapter
import com.example.serviceapp.view_pager_example.presentation.router.PhoneInfoRouter
import kotlinx.android.synthetic.main.view_pager_activity.*

class StartPagerActivity : AppCompatActivity(){
    private lateinit var adapter: StartActivityViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager_activity)

        initVies()
    }

    private fun initVies() {
        adapter = StartActivityViewPagerAdapter(supportFragmentManager)
        view_pager.adapter = adapter
    }

    fun nextPage() {
        val currentItemIndex = view_pager.currentItem
        if (hasNextPage()) {
            view_pager.currentItem = currentItemIndex + 1
        }
    }

    fun closeViewPager() {
        finish()
    }

    private fun hasNextPage(): Boolean {
        return view_pager.currentItem < (adapter.count - 1)
    }
}