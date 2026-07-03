package com.autodoc.project.screens

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

import com.autodoc.project.services.news.NewsFactory
import com.autodoc.project.services.news.NewsEntity

class NewsViewModel: ViewModel() {

    private val newsFactory = NewsFactory()

    @NativeCoroutinesState
    val news: StateFlow<List<NewsEntity>> = newsFactory.news
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun fetchNews(offset: Int, limit: Int) {
        newsFactory.fetchNews(offset, limit)
    }
}