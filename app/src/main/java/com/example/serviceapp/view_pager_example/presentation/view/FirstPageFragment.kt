package com.example.serviceapp.view_pager_example.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.serviceapp.R
import kotlinx.android.synthetic.main.view_pager_slide_1.*
import kotlinx.android.synthetic.main.view_pager_slide_2.*

class FirstPageFragment: Fragment() {
    companion object {
        const val TAG = "FirstPageFragment"

        fun newInstance(): FirstPageFragment {
            return FirstPageFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_pager_slide_1, container, false)
    }

    override fun onResume() {
        super.onResume()
        first_page_button.setOnClickListener {
            val activity = requireActivity()
            if (activity is StartPagerActivity) {
                activity.nextPage()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        first_page_button.setOnClickListener(null)
    }
}