package com.autodoc.project.services.news

interface NewsService {
    suspend fun fetchNews(offset: Int, limit: Int): List<NewsModel>
}