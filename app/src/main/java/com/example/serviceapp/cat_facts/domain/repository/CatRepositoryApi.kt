package com.example.serviceapp.cat_facts.domain.repository

import com.example.serviceapp.cat_facts.models.pojo.CatFactBean
import io.reactivex.Single

interface CatRepositoryApi {
    fun getCatFact() : Single<CatFactBean>
}