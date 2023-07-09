package com.example.kotlinanimemangaapp.presentation.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kotlinanimemangaapp.presentation.screens.LoginContent
import com.example.kotlinanimemangaapp.presentation.screens.LoginScreen
import com.example.kotlinanimemangaapp.presentation.screens.ScreenContent
import com.example.kotlinanimemangaapp.presentation.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.AUTHENTICATION_ROUTE,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController)
            /*LoginContent(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME_ROUTE)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )*/
        }
        composable(route = AuthScreen.SignUp.route) {
            ScreenContent(name = AuthScreen.SignUp.route) {}
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
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
