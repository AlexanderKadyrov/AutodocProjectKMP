package com.autodoc.project

import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.compose.material3.Surface
import kotlinx.serialization.Serializable

import com.autodoc.project.screens.ContentView

@Serializable
object ListDestination

@Composable
fun App() {
    MaterialTheme {
        Surface {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = ListDestination) {
                composable<ListDestination> {
                    ContentView()
                }
            }
        }
    }
}