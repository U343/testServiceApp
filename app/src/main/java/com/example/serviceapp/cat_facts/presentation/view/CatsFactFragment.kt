package com.example.serviceapp.cat_facts.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.serviceapp.R
import com.example.serviceapp.cat_facts.domain.application.CatFactsProvider
import com.example.serviceapp.cat_facts.presentation.view_models.CatFactsViewModel
import com.example.serviceapp.cat_facts.presentation.view_models.CatFactsViewModelFactory
import kotlinx.android.synthetic.main.cat_facts_fragment.*
import kotlinx.android.synthetic.main.start_activity.*

class CatsFactFragment : Fragment() {
    private lateinit var viewModel: CatFactsViewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = (requireContext().applicationContext as CatFactsProvider).getRepository()

        viewModel = ViewModelProvider(
            this,
            CatFactsViewModelFactory(repository)
        ).get(CatFactsViewModel::class.java)

        cat_facts_get_button.setOnClickListener { viewModel.loadCatFacts() }

        viewModel.catFactsData.observe(this) { data ->
            cat_facts_first_text_view.text = data.firstFact
            cat_facts_second_text_view.text = data.secondFact
        }
    }
}