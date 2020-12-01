package com.example.serviceapp.cat_facts.domain.application

import android.app.Application
import com.example.serviceapp.cat_facts.data.cat_fact_request.query_interface.CatFactsApi
import com.example.serviceapp.cat_facts.data.cat_fact_request.query_object.RetrofitProvider
import com.example.serviceapp.cat_facts.domain.repository.CatRepositoryApi
import com.example.serviceapp.cat_facts.domain.repository.CatRepositoryFactory

class CustomApplication : Application(), CatFactsProvider {
    private lateinit var repository: CatRepositoryApi

    override fun onCreate() {
        super.onCreate()

        val retrofitService = RetrofitProvider.getRetrofitObject().create(CatFactsApi::class.java)
        repository = CatRepositoryFactory.getRepository(retrofitService)
    }

    override fun getRepository() : CatRepositoryApi {
        return repository
    }
}