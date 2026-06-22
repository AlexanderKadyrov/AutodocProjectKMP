package com.autodoc.project.services.news

import kotlinx.serialization.Serializable

@Serializable
internal data class NewsResponse(
    val news: List<NewsModel>
)