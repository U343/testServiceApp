package com.example.serviceapp.view_pager_example.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.serviceapp.view_pager_example.presentation.view.FirstPageFragment
import com.example.serviceapp.view_pager_example.presentation.view.SecondPageFragment

class StartActivityViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val FIRST_PAGE_POSITION = 0
    private val SECOND_PAGE_POSITION = 1
    private val PAGES_COUNT = 2

    override fun getCount() = PAGES_COUNT

    override fun getItem(position: Int): Fragment {
        return when (position) {
            FIRST_PAGE_POSITION -> FirstPageFragment.newInstance()
            SECOND_PAGE_POSITION -> SecondPageFragment.newInstance()
            else -> throw IllegalArgumentException("Error num $position")
        }
    }
}