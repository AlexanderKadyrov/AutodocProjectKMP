package com.autodoc.project.screens

import com.autodoc.project.providers.news.NewsNetworkProvider

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn
import com.rickclephas.kmp.observableviewmodel.launch

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.Flow

class NewsViewModel: ViewModel() {

    private val provider = NewsNetworkProvider()

    private val _newsViewModels = MutableStateFlow(emptyList<NewsEntityViewModel>())

    @NativeCoroutinesState
    val newsViewModels: StateFlow<List<NewsEntityViewModel>> = _newsViewModels
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun fetchNews(offset: Int, limit: Int) {
        viewModelScope.launch {
            fetchNewsAsFlow(offset, limit)
                .collectLatest {
                    _newsViewModels.value = it
                }
        }
    }

    private suspend fun fetchNewsAsFlow(offset: Int, limit: Int): Flow<List<NewsEntityViewModel>> {
        val viewModels = provider
            .fetchNews(offset, limit)
            .map { NewsEntityViewModel(it) }
        return flowOf(viewModels)
    }
}