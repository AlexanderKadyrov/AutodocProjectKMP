package com.autodoc.project

import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

import androidx.compose.runtime.Composable
import com.autodoc.project.destinations.NewsDetailView
import com.autodoc.project.destinations.NewsListView

import com.autodoc.project.views.NavigationTopAppBar
import com.autodoc.project.views.NavigationHost
import com.autodoc.project.views.CustomWebView
import com.autodoc.project.views.NewsListView

@Composable
fun AppContentView() {
    val navController = rememberNavController()
    NavigationHost(
        navController = navController,
        startDestination = NewsListView
    ) {
        composable<NewsListView> {
            NavigationTopAppBar(title = "News") {
                NewsListView { url ->
                    navController.navigate(NewsDetailView(url))
                }
            }
        }
        composable<NewsDetailView> { backStackEntry ->
            NavigationTopAppBar(
                onBackClick = {
                    navController.popBackStack()
                }) {
                val destination = backStackEntry.toRoute<NewsDetailView>()
                CustomWebView(destination.url)
            }
        }
    }
}