package com.example.kotlinanimemangaapp.presentation.navigation.bottom_bar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinanimemangaapp.presentation.screens.HomeScreen
import com.example.kotlinanimemangaapp.presentation.screens.ProfileScreen
import com.example.kotlinanimemangaapp.presentation.screens.SearchScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(BottomBarScreen.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}
/*
fun NavGraphBuilder.bottomBarNavGraph(
    navController: NavHostController
) {
    navigation(
        route = HOME_ROUTE,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(BottomBarScreen.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}*/