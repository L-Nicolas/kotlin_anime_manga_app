package com.example.kotlinanimemangaapp.data.remote.dto.assets

import com.squareup.moshi.Json

data class MangaDetailResponse(
    @Json(name = "data")
    val `data`: MangaDto
)