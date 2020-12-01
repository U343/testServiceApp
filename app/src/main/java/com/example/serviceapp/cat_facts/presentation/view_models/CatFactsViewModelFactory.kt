package com.example.serviceapp.cat_facts.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.serviceapp.cat_facts.domain.repository.CatRepositoryApi

/**
 * Фабрика вью модели с информацией о гисте
 *
 * Позволяет передать вью модели [GistRepositoryApi] параметр
 *
 * @param repository репозиторий списка гистов
 *
 * @author Dmitrii Bondarev on 13.11.2020
 */
class CatFactsViewModelFactory(private val repository: CatRepositoryApi) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatFactsViewModel(repository) as T
    }
}