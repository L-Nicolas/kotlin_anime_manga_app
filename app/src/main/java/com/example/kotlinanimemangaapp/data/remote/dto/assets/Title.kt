package com.example.kotlinanimemangaapp.data.remote.dto.assets


import com.squareup.moshi.Json

data class Title(
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: String
)