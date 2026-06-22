package com.autodoc.project.screens

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

import com.autodoc.project.services.news.NewsRepository
import com.autodoc.project.services.news.NewsModel

class NewsViewModel: ViewModel() {

    private val newsRepository = NewsRepository()

    @NativeCoroutinesState
    val news: StateFlow<List<NewsModel>> = newsRepository.news
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun fetchNews(offset: Int, limit: Int) {
        newsRepository.fetchNews(offset, limit)
    }
}