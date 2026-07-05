package com.autodoc.project.providers.news

import com.autodoc.project.services.news.NewsEntity

interface NewsProvider {
    suspend fun fetchNews(offset: Int, limit: Int): List<NewsEntity>
}