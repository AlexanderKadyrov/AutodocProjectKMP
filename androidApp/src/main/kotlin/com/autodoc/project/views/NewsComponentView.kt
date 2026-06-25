package com.autodoc.project.views

import com.autodoc.project.services.news.NewsModel

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun NewsComponentView(
    model: NewsModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .border(width = 1.dp, color = Color(0xFF808080), shape = RoundedCornerShape(15.dp))
                .padding(top = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
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
            model.titleImageUrl?.let {
                AsyncImage(
                    model = it,
                    contentDescription = model.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .fillMaxWidth()
                )
            }
        }
    }
}