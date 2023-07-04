package com.example.kotlinanimemangaapp.data.remote.dto.assets


import com.squareup.moshi.Json

data class Images(
    @Json(name = "jpg")
    val jpg: Jpg,
    @Json(name = "webp")
    val webp: Webp
)