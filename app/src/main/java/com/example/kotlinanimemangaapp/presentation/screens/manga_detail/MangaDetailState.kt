package com.example.kotlinanimemangaapp.presentation.screens.manga_detail

import com.example.kotlinanimemangaapp.domain.model.Manga

data class MangaDetailState(
    val isLoading: Boolean = false,
    val manga: Manga? = null,
    val error: String = ""
)