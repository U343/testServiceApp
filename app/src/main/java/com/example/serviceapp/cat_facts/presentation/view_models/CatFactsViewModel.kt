package com.example.serviceapp.cat_facts.presentation.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.serviceapp.cat_facts.domain.repository.CatRepositoryApi
import com.example.serviceapp.cat_facts.models.presentation.CatFactsModel
import io.reactivex.Single.zip
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CatFactsViewModel(private val repository: CatRepositoryApi) : ViewModel() {
    val catFactsData = MutableLiveData<CatFactsModel>()
    private val dispose = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        dispose.clear()
    }

    fun loadCatFacts() {
        /*dispose.add(repository.getCatFact()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                catFactsData.value = CatFactsModel(data.fact, data.fact)
            }, { Log.d("rxjavaProcess", "onFailure CatFactsViewModel") }))*/


        val thread1 = repository.getCatFact()
            .doOnSuccess({ Log.d("threadManage", "thread1 " + Thread.currentThread().name) })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val thread2 = repository.getCatFact()
            .doOnSuccess({ Log.d("threadManage", "thread2 " + Thread.currentThread().name) })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val result = zip(
            thread1,
            thread2,
            { a, b ->
                Log.d("threadManage", "zip " + Thread.currentThread().name)
                CatFactsModel(a.fact, b.fact)
            })

        dispose.add(
            result.subscribe(
                {
                    catFactsData.value = it
                    Log.d("threadManage", "subscribe " + Thread.currentThread().name)},
                { Log.d("rxjavaProcess", "onFailure CatFactsViewModel") })
        )
    }
}