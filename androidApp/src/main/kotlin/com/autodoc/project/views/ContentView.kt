package com.autodoc.project.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable

import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import com.autodoc.project.screens.NewsViewModel

@Composable
fun ContentView() {
    val viewModel = NewsViewModel()
    LaunchedEffect(Unit) {
        viewModel.fetchNews(1, 15)
    }
    val news by viewModel.news.collectAsStateWithLifecycle()
    AnimatedContent(news.isNotEmpty()) { isAvailableContent ->
        if (isAvailableContent) {
            LazyColumn(
                contentPadding = WindowInsets.safeDrawing.asPaddingValues()
            ) {
                items(news) { model ->
                    NewsComponentView(model)
                }
            }
        } else {
            ContentEmptyView(Modifier.fillMaxSize())
        }
    }
}