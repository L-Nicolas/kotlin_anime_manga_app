package com.example.kotlinanimemangaapp.domain.repository

import com.example.kotlinanimemangaapp.domain.model.Manga

interface MangaRepository {
    suspend fun getManga(): Manga?
}