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

import kotlinx.serialization.Serializable

import com.autodoc.project.views.ContentView

@Serializable
object ListDestination

@Serializable
object DetailDestination

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
                startDestination = ListDestination
            ) {
                composable<ListDestination> {
                    ContentView()
                }
                composable<DetailDestination> {

                }
            }
        }
    }
}