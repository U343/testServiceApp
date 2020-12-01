package com.example.serviceapp.cat_facts.models.pojo

import com.google.gson.annotations.SerializedName

data class CatFactBean(
    @SerializedName("fact") val fact: String
)