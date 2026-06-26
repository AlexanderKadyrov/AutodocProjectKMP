package com.autodoc.project.views

import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.autodoc.project.screens.NewsViewModel

@Composable
fun NewsListView(
    clickable: (String) -> Unit
) {
    val viewModel = NewsViewModel()
    LaunchedEffect(Unit) {
        viewModel.fetchNews(1, 15)
    }
    val news by viewModel.news.collectAsStateWithLifecycle()
    LazyColumn(
        contentPadding = WindowInsets.safeDrawing.asPaddingValues()
    ) {
        items(news) { model ->
            NewsComponentView(
                model = model,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        clickable(model.fullUrl)
                    }
            )
        }
    }
}