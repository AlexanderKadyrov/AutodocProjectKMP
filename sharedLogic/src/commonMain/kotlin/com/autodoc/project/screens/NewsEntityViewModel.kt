package com.autodoc.project.screens

import com.autodoc.project.repositories.NewsRepository
import com.autodoc.project.services.news.NewsEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsEntityViewModel(
    entity: NewsEntity
): KoinComponent {

    private val newsRepository: NewsRepository by inject()

}