package com.autodoc.project.NewsService

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class NewsModel(
    val id: Int,
    val title: String,

    @SerialName("description")
    val descriptions: String,

    val publishedDate: String,
    val url: String,
    val fullUrl: String,
    val titleImageUrl: String? = null,
    val categoryType: String
)
