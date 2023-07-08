package com.example.kotlinanimemangaapp.presentation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinanimemangaapp.presentation.screens.AnimatedSplashScreen
import com.example.kotlinanimemangaapp.presentation.screens.ROOT_ROUTE
import com.example.kotlinanimemangaapp.presentation.screens.Screen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AnimatedSplashScreen.route,
        route = ROOT_ROUTE,
    ){
        composable(route = Screen.AnimatedSplashScreen.route) {
            AnimatedSplashScreen(navController = navController)
        }
        authNavGraph(navController = navController)
        homeNavGraph(navController = navController)
    }
}