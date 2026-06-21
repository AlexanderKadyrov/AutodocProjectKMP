package com.autodoc.project.screens

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.autodoc.project.services.news.NewsRepository
import com.autodoc.project.services.news.NewsModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class NewsViewModel {

    private val repository = NewsRepository()

    @NativeCoroutinesState
    val news: StateFlow<List<NewsModel>> = repository.news
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}