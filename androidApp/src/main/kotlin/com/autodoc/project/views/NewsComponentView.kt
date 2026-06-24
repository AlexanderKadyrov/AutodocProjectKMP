package com.autodoc.project.views

import com.autodoc.project.services.news.NewsModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsComponentView(model: NewsModel) {
    Column {
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(model.title)
                Text(model.descriptions)
            }
        }
    }
}