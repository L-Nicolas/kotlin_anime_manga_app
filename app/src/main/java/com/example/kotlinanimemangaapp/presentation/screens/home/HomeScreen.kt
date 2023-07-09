package com.example.kotlinanimemangaapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kotlinanimemangaapp.domain.model.Manga
import com.example.kotlinanimemangaapp.presentation.components.CustomItem
import com.example.kotlinanimemangaapp.presentation.navigation.bottom_bar.BottomBarScreen
import com.example.kotlinanimemangaapp.presentation.navigation.nav_graph.HomeNavGraph

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: MangaListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
        val mangas = listOf<Manga>(
            Manga(
                id = 1,
                title = "Naruto",
                popularity = 1,
                image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
            ),
            Manga(
                id = 2,
                title = "SNK",
                popularity = 1,
                image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
            ),
            Manga(
                id = 3,
                title = "Bleach",
                popularity = 1,
                image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
            ),
            Manga(
                id = 4,
                title = "One Piece",
                popularity = 1,
                image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
            ),
            Manga(
                id = 5,
                title = "Naruto",
                popularity = 1,
                image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
            ),
            Manga(
                id = 6,
                title = "SNK",
                popularity = 1,
                image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
            ),
            Manga(
                id = 7,
                title = "Bleach",
                popularity = 1,
                image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
            )
        )
        val listcategory = listOf<String>(
            "Action",
            "Adventure",
            "Cars",
            "Comedy"
        )
        LazyColumn(
            contentPadding = PaddingValues(all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            listcategory.forEach { category ->
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(12.dp),
                        text = category,
                    )
                }
                item {
                    row(mangas = state.mangas)
                }
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
    }
}

@Composable
fun row(mangas: List<Manga>) {
    //take only 5 items
    val fewMangas = mangas.take(5)
    LazyRow (
        contentPadding = PaddingValues(all = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(fewMangas) {manga ->
            CustomItem(manga = manga, onItemClick = { /*TODO*/ })
        }
    }
}


@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navController = navController,
                contentDescription = screen.title,
                currentDestination = currentRoute
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    navController: NavController,
    contentDescription: String,
    currentDestination: NavDestination?
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = screen.icon, contentDescription = contentDescription) },
        label = { androidx.compose.material.Text(text = screen.title) },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
    )
}
