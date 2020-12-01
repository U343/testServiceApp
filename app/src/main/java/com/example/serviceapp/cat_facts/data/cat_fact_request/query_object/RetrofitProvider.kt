package com.example.serviceapp.cat_facts.data.cat_fact_request.query_object

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    /**
     * Аресс Api с фактами о кошачьих
     */
    private const val BASE_URL = "https://catfact.ninja"

    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    /**
     * Объект для создания логов
     */
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    /**
     * Получить объект Retrofit
     *
     * @return Retrofit объект
     */
    fun getRetrofitObject(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}