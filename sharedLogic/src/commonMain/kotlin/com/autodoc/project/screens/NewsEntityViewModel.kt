package com.autodoc.project.screens

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch

import com.autodoc.project.repositories.NewsRepository
import com.autodoc.project.services.news.NewsEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsEntityViewModel(
    val entity: NewsEntity
): ViewModel(), KoinComponent {

    private val newsRepository: NewsRepository by inject()

    private val _isFavorite = MutableStateFlow(false)

    @NativeCoroutinesState
    val isFavorite: StateFlow<Boolean>
        get() {
            return _isFavorite
        }

    fun tapFavorite() {
        _isFavorite.value = !_isFavorite.value
        viewModelScope.launch {
            newsRepository.add(entity)
        }
    }
}