package com.autodoc.project

import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.autodoc.project.destinations.NewsDetailView
import com.autodoc.project.destinations.NewsListView

import com.autodoc.project.views.NavigationTopAppBar
import com.autodoc.project.views.NavigationHost
import com.autodoc.project.views.CustomWebView
import com.autodoc.project.views.NewsListView

@Composable
fun App() {
    val navController = rememberNavController()
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
            NavigationTopAppBar(
                onBackClick = {
                    navController.popBackStack()
                }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    val destination = backStackEntry.toRoute<NewsDetailView>()
                    CustomWebView(destination.url)
                }
            }
        }
    }
}