package com.example.kotlinanimemangaapp.presentation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kotlinanimemangaapp.presentation.navigation.bottom_bar.BottomBarScreen
import com.example.kotlinanimemangaapp.presentation.screens.ProfileScreen
import com.example.kotlinanimemangaapp.presentation.screens.ScreenContent


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME_ROUTE,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
        }
        composable(route = BottomBarScreen.Search.route) {
            ScreenContent(
                name = BottomBarScreen.Search.route,
                onClick = { }
            )
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            ScreenContent(name = DetailsScreen.Information.route) {}
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
}
