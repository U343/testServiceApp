package com.example.serviceapp.cat_facts.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.serviceapp.R

class CatsFactFragment : Fragment() {
    companion object {
        const val TAG = "CatsFactFragment"

        fun newInstance(): CatsFactFragment {
            return CatsFactFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("fragmentLifecycle", "CatsFactFragment")
        return inflater.inflate(R.layout.cat_facts_fragment, container, false)
    }
}