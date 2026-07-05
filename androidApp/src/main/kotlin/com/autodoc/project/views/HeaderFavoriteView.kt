package com.autodoc.project.views

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Row

import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.filled.Star

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons

import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.Composable

@Composable
fun HeaderFavoriteView(
    title: String,
    isFavorite: Boolean,
    onFavoriteAction: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(
            onClick = onFavoriteAction,
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.Black.copy(alpha = 0.7F)
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            if (isFavorite) {
                Icon(imageVector = Icons.Filled.Star,null, tint = Color.Yellow)
            } else {
                Icon(imageVector = Icons.Outlined.Star,null, tint = Color.Gray)
            }
        }
    }
}