package com.example.kotlinanimemangaapp.presentation.screens.home

import com.example.kotlinanimemangaapp.domain.model.Manga

data class MangaListState(
    val isLoading: Boolean = false,
    val mangas: List<Manga> = emptyList(),
    val error: String = ""
)
