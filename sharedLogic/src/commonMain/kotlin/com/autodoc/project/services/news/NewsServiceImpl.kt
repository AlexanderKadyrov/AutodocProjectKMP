package com.autodoc.project.services.news

import kotlin.coroutines.cancellation.CancellationException
import io.ktor.client.request.get
import io.ktor.client.HttpClient
import io.ktor.client.call.body

internal class NewsServiceImpl(
    private val client: HttpClient
): NewsService {

    override suspend fun fetchNews(offset: Int, limit: Int): List<NewsEntity> {
        return fetchNewsResponse(offset, limit).news
    }

    private suspend fun fetchNewsResponse(offset: Int, limit: Int): NewsResponse {
        return try {
            val url = "$API_NEWS_ENDPOINT/$offset/$limit"
            client.get(url).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()
            NewsResponse(emptyList())
        }
    }

    companion object {
        private const val API_NEWS_ENDPOINT = "https://webapi.autodoc.ru/api/news"
    }
}