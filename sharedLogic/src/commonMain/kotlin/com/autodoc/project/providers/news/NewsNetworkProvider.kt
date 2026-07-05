package com.autodoc.project.providers.news

import com.autodoc.project.services.news.NewsEntity
import com.autodoc.project.services.news.NewsService

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

import kotlin.getValue

class NewsNetworkProvider: NewsProvider, KoinComponent {

    private val newsService: NewsService by inject()

    override suspend fun fetchNews(offset: Int, limit: Int): List<NewsEntity> {
        return newsService.fetchNews(offset, limit)
    }
}