package com.example.kotlinanimemangaapp.data.remote.dto.assets

import com.squareup.moshi.Json

data class MangaResponse(
    @Json(name = "data")
    val `data`: MangaDto
)
