package com.example.serviceapp.cat_facts.data.repository

import com.example.serviceapp.cat_facts.data.cat_fact_request.query_interface.CatFactsApi
import com.example.serviceapp.cat_facts.domain.repository.CatRepositoryApi
import com.example.serviceapp.cat_facts.models.pojo.CatFactBean
import io.reactivex.Single

class CatRepository(private val catFactApi: CatFactsApi) : CatRepositoryApi {

    override fun getCatFact() : Single<CatFactBean> {
        return catFactApi.getCatFact()
    }
}