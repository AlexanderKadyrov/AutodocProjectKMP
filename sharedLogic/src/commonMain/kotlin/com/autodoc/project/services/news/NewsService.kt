package com.autodoc.project.services.news

internal interface NewsService {
    suspend fun fetchNews(offset: Int, limit: Int): List<NewsModel>
}