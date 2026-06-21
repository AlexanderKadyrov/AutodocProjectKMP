package com.autodoc.project.screens

import com.autodoc.project.services.news.NewsService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsViewModel(): KoinComponent {

    private val newsService: NewsService by inject()
}