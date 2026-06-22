package com.autodoc.project.di

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import com.autodoc.project.services.news.NewsServiceImpl
import com.autodoc.project.services.news.NewsService
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import io.ktor.client.HttpClient
import io.ktor.http.ContentType
import org.koin.dsl.module

private val dataModule = module {
    single<HttpClient> {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
        }
    }
    single<NewsService> {
        NewsServiceImpl(get())
    }
}

fun initKoin() {
    startKoin {
        modules(dataModule)
    }
}