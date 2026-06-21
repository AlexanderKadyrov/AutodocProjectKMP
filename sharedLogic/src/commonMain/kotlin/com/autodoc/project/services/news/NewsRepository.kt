package com.autodoc.project.services.news

import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

internal class NewsRepository: KoinComponent {

    private val newsService: NewsService by inject()

    private val coroutineScope = CoroutineScope(SupervisorJob())
    private val storedObjects = MutableStateFlow(emptyList<NewsModel>())

    val news: Flow<List<NewsModel>>
        get() {
            return storedObjects
        }

    fun fetchNews(offset: Int, limit: Int) {
        coroutineScope.launch {
            val result = newsService.fetchNews(offset, limit)
            storedObjects.value = result
        }
    }
}