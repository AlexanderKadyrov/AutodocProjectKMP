package com.autodoc.project.services.news

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
@Serializable
data class NewsModel(

    @PrimaryKey
    val id: Int,

    val title: String,

    @SerialName("description")
    val descriptions: String,

    @Serializable(with = DateTimeSerializer::class)
    val publishedDate: String,

    val url: String,
    val fullUrl: String,
    val titleImageUrl: String? = null,
    val categoryType: String
)