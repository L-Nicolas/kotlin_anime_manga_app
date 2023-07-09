package com.example.kotlinanimemangaapp.data.repository

import com.example.kotlinanimemangaapp.data.remote.api.MangaApi
import com.example.kotlinanimemangaapp.data.remote.dto.assets.toManga
import com.example.kotlinanimemangaapp.domain.model.Manga
import com.example.kotlinanimemangaapp.domain.repository.MangaRepository
import javax.inject.Inject

class MangaDatasource @Inject constructor(
    private val mangaApi: MangaApi
) : MangaRepository {

    override suspend fun getManga(): Manga? = mangaApi.getManga().data?.toManga()

    override suspend fun getMangas(): List<Manga> = mangaApi.getMangas().data?.map {
        it.toManga()
    } ?: emptyList()
}
