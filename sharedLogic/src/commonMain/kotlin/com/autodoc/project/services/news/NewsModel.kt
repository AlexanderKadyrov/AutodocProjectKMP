package com.autodoc.project.services.news

import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.LocalDateTime

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
) {
    @OptIn(FormatStringsInDatetimeFormats::class)
    fun formattedDate(): String {
        val inputFormat = LocalDateTime.Format { byUnicodePattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]") }
        val outputFormat = LocalDateTime.Format { byUnicodePattern("dd.MM.yyyy") }
        val dateTime = inputFormat.parse(publishedDate)
        return outputFormat.format(dateTime)
    }
}