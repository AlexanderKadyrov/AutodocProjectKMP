package com.autodoc.project.views

import com.autodoc.project.services.news.NewsModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NewsComponentView(model: NewsModel) {
    Column {
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = model.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = model.descriptions,
                    fontSize = 14.sp,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = model.publishedDate,
                        fontSize = 12.sp
                    )
                    Text(
                        text = model.categoryType,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}