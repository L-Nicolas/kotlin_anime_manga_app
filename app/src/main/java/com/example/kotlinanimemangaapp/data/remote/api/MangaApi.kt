package com.example.kotlinanimemangaapp.data.remote.api

import com.example.kotlinanimemangaapp.data.remote.dto.assets.MangaDetailResponse
import com.example.kotlinanimemangaapp.data.remote.dto.assets.MangaResponse
import retrofit2.http.GET

interface MangaApi {
    @GET("/v4/manga/1")
    suspend fun getManga(): MangaDetailResponse

    @GET("/v4/manga")
    suspend fun getMangas(): MangaResponse
}