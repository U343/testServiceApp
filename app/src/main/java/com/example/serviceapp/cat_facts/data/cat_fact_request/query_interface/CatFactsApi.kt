package com.example.serviceapp.cat_facts.data.cat_fact_request.query_interface

import com.example.serviceapp.cat_facts.models.pojo.CatFactBean
import io.reactivex.Single
import retrofit2.http.GET

interface CatFactsApi {

    @GET("/fact")
    fun getCatFact() : Single<CatFactBean>
}