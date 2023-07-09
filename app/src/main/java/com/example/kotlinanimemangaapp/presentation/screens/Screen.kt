package com.example.kotlinanimemangaapp.presentation.screens

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
