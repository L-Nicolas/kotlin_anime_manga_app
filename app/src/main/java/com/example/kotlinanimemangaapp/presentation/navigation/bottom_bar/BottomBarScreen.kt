package com.example.kotlinanimemangaapp.presentation.navigation.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Home : BottomBarScreen(
        route = "home_screen",
        icon = Icons.Default.Home,
        title = "Home"
    )
    object Search : BottomBarScreen(
        route = "search_screen",
        icon = Icons.Default.Search,
        title = "Search"
    )
    object Profile : BottomBarScreen(
        route = "profile_screen",
        icon = Icons.Default.Place,
        title = "Profile"
    )
}

