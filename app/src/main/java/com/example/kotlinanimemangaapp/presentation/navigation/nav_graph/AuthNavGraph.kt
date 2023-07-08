package com.example.kotlinanimemangaapp.presentation.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kotlinanimemangaapp.presentation.screens.AUTHENTICATION_ROUTE
import com.example.kotlinanimemangaapp.presentation.screens.Screen
import com.example.kotlinanimemangaapp.presentation.screens.LoginScreen
import com.example.kotlinanimemangaapp.presentation.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        route = AUTHENTICATION_ROUTE,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
    }
}


/*
fun NavGraphBuilder.authenticationComposable(
    navController: NavController,
    startDestination: String,
    route: String,
    authenticationViewModel: AuthenticationViewModel,
    onAuthenticationSuccess: () -> Unit
) {
    navigation(
        startDestination = startDestination,
        route = route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(
                navController = navController,
                authenticationViewModel = authenticationViewModel,
                onAuthenticationSuccess = onAuthenticationSuccess
            )
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(
                navController = navController
            )
        }
    }
}*/
