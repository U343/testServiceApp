package com.example.serviceapp.cat_facts.presentation.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.serviceapp.cat_facts.models.presentation.CatFactsModel

class CatsFactsViewModel : ViewModel() {
    val catFactsData = MutableLiveData<CatFactsModel>()
}