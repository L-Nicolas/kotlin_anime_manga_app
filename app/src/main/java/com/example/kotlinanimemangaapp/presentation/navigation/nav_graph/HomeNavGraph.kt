package com.example.kotlinanimemangaapp.presentation.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kotlinanimemangaapp.presentation.screens.DetailsScreen
import com.example.kotlinanimemangaapp.presentation.screens.MAIN_ROUTE
import com.example.kotlinanimemangaapp.presentation.screens.MainScreen
import com.example.kotlinanimemangaapp.presentation.screens.Screen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        route = MAIN_ROUTE,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Main.route) {
            MainScreen()
        }
        composable(route = Screen.Details.route) {
            DetailsScreen()
        }
    }
}
