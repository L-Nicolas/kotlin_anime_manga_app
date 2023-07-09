package com.example.kotlinanimemangaapp.data.remote.api

import com.example.kotlinanimemangaapp.common.Constants
import com.example.kotlinanimemangaapp.data.remote.dto.assets.MangaDetailResponse
import com.example.kotlinanimemangaapp.data.remote.dto.assets.MangaResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApi {

    @GET("/v4/manga")
    suspend fun getMangas(): MangaResponse

    @GET("/v4/manga/{mangaId}")
    suspend fun getManga(@Path("mangaId") mangaId: Int): MangaDetailResponse
}