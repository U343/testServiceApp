package com.example.serviceapp.cat_facts.domain.repository

import com.example.serviceapp.cat_facts.data.cat_fact_request.query_interface.CatFactsApi
import com.example.serviceapp.cat_facts.data.repository.CatRepository

object CatRepositoryFactory {
    fun getRepository(catFactsApi: CatFactsApi) : CatRepositoryApi {
        return CatRepository(catFactsApi)
    }
}