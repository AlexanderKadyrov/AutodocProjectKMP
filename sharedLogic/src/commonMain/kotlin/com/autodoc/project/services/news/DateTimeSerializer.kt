package com.autodoc.project.services.news

import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.datetime.LocalDateTime

internal object DateTimeSerializer: KSerializer<String> {

    private const val YYYY_MM_DD_FORMAT_VALUE = "yyyy-MM-dd'T'HH:mm:ss[.SSS]"
    private const val DD_MM_YYYY_FORMAT_VALUE = "dd.MM.yyyy"

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("DateTimeSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: String) {
        val formattedDate = formattedDate(
            value,
            DD_MM_YYYY_FORMAT_VALUE,
            YYYY_MM_DD_FORMAT_VALUE
        )
        encoder.encodeString(formattedDate)
    }

    override fun deserialize(decoder: Decoder): String {
        val formattedDate = formattedDate(
            decoder.decodeString(),
            YYYY_MM_DD_FORMAT_VALUE,
            DD_MM_YYYY_FORMAT_VALUE
        )
        return formattedDate
    }

    @OptIn(FormatStringsInDatetimeFormats::class)
    private fun formattedDate(
        value: String,
        inputFormatValue: String,
        outputFormatValue: String
    ): String {
        val inputFormat = LocalDateTime.Format { byUnicodePattern(inputFormatValue) }
        val outputFormat = LocalDateTime.Format { byUnicodePattern(outputFormatValue) }
        val dateTime = inputFormat.parse(value)
        return outputFormat.format(dateTime)
    }
}