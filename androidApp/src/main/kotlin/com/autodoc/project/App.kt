package com.autodoc.project

import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.navigation.toRoute

import kotlinx.serialization.Serializable

import com.autodoc.project.views.NavigationTopAppBarBar
import com.autodoc.project.views.CustomWebView
import com.autodoc.project.views.NewsListView

@Serializable
object NewsListView

@Serializable
data class DetailDestination(
    val url: String
)

@Composable
fun App(
    navController: NavHostController
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            NavHost(
                navController = navController,
                startDestination = NewsListView
            ) {
                composable<NewsListView> {
                    NewsListView { url ->
                        navController.navigate(DetailDestination(url))
                    }
                }
                composable<DetailDestination> { backStackEntry ->
                    NavigationTopAppBarBar(
                        onBackClick = {
                            navController.popBackStack()
                        }) {
                        val url = backStackEntry.toRoute<DetailDestination>().url
                        CustomWebView(url)
                    }
                }
            }
        }
    }
}