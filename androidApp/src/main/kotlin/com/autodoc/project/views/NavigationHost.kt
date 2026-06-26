package com.autodoc.project.views

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.compose.material3.Surface
import com.autodoc.project.NewsListView

@Composable
fun NavigationHost(
    navController: NavHostController,
    builder: NavGraphBuilder.() -> Unit
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            NavHost(
                navController = navController,
                startDestination = NewsListView,
                builder = builder
            )
        }
    }
}