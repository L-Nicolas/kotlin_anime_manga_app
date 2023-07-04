package com.example.kotlinanimemangaapp.data.remote.dto.assets


import com.squareup.moshi.Json

data class Author(
    @Json(name = "mal_id")
    val malId: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String
)