package com.autodoc.project.services.news

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val news: List<NewsModel>
)