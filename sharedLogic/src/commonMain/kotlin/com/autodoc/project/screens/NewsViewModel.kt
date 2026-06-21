package com.autodoc.project.screens

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

import com.autodoc.project.services.news.NewsRepository
import com.autodoc.project.services.news.NewsModel

class NewsViewModel: ViewModel() {

    private val repository = NewsRepository()

    @NativeCoroutinesState
    val news: StateFlow<List<NewsModel>> = repository.news
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}