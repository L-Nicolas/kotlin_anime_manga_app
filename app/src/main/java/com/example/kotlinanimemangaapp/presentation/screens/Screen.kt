package com.example.kotlinanimemangaapp.presentation.screens

const val AUTHENTICATION_ROUTE = "authentication"
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"
const val MAIN_ROUTE = "main"

sealed class Screen(val route: String) {
    object AnimatedSplashScreen : Screen("splash_screen")
    object Login : Screen("login_screen")
    object SignUp : Screen("sign_up_screen")
    object Main : Screen("main_screen")
    object Details : Screen("details_screen")
    object Home : Screen("home_screen")
    object Search : Screen("search_screen")
    object Profile : Screen("profile_screen")
}
