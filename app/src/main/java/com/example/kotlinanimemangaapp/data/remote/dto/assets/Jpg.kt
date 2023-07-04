package com.example.kotlinanimemangaapp.data.remote.dto.assets


import com.squareup.moshi.Json

data class Jpg(
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "large_image_url")
    val largeImageUrl: String,
    @Json(name = "small_image_url")
    val smallImageUrl: String
)