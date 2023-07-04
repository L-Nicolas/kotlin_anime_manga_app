package com.example.kotlinanimemangaapp.data.remote.dto.assets


import com.squareup.moshi.Json

data class From(
    @Json(name = "day")
    val day: Int,
    @Json(name = "month")
    val month: Int,
    @Json(name = "year")
    val year: Int
)