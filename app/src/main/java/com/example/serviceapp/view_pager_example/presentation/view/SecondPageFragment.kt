package com.example.serviceapp.view_pager_example.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import kotlinx.android.synthetic.main.view_pager_slide_1.*
import kotlinx.android.synthetic.main.view_pager_slide_2.*

class SecondPageFragment: Fragment() {
    companion object {
        const val TAG = "SecondPageFragment"

        fun newInstance(): SecondPageFragment {
            return SecondPageFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_pager_slide_2, container, false)
    }

    override fun onResume() {
        super.onResume()
        second_page_button.setOnClickListener {
            val activity = requireActivity()
            if (activity is StartPagerActivity) {
                activity.closeViewPager()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        second_page_button.setOnClickListener(null)
    }
}