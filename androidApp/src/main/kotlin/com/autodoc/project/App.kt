package com.autodoc.project

import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import androidx.navigation.toRoute

import kotlinx.serialization.Serializable

import com.autodoc.project.views.NavigationTopAppBarBar
import com.autodoc.project.views.NavigationHost
import com.autodoc.project.views.CustomWebView
import com.autodoc.project.views.NewsListView

@Serializable
object NewsListView

@Serializable
data class NewsDetailView(
    val url: String
)

@Composable
fun App(
    navController: NavHostController
) {
    NavigationHost(
        navController = navController,
        startDestination = NewsListView
    ) {
        composable<NewsListView> {
            NewsListView { url ->
                navController.navigate(NewsDetailView(url))
            }
        }
        composable<NewsDetailView> { backStackEntry ->
            NavigationTopAppBarBar(
                onBackClick = {
                    navController.popBackStack()
                }) {
                val destination = backStackEntry.toRoute<NewsDetailView>()
                CustomWebView(destination.url)
            }
        }
    }
}