package com.example.serviceapp.cat_facts.domain.application

import com.example.serviceapp.cat_facts.domain.repository.CatRepositoryApi

interface CatFactsProvider {
    fun getRepository() : CatRepositoryApi
}