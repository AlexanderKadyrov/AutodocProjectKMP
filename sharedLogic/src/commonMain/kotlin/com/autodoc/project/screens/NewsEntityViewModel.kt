package com.autodoc.project.screens

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch

import com.autodoc.project.repositories.NewsRepository
import com.autodoc.project.services.news.NewsEntity

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsEntityViewModel(
    val entity: NewsEntity
): ViewModel(), KoinComponent {

    private val newsRepository: NewsRepository by inject()

    fun addFavorite() {
        viewModelScope.launch {
            newsRepository.add(entity)
        }
    }
}