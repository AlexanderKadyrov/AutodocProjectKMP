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

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("DateTimeSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: String) {
        TODO("Not yet implemented")
    }

    override fun deserialize(decoder: Decoder): String {
        return formattedDate(decoder.decodeString())
    }

    @OptIn(FormatStringsInDatetimeFormats::class)
    private fun formattedDate(rawValue: String): String {
        val inputFormat = LocalDateTime.Format { byUnicodePattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]") }
        val outputFormat = LocalDateTime.Format { byUnicodePattern("dd.MM.yyyy") }
        val dateTime = inputFormat.parse(rawValue)
        return outputFormat.format(dateTime)
    }
}