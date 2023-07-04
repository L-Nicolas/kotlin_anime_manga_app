package com.example.kotlinanimemangaapp.data.remote.dto.assets


import com.squareup.moshi.Json

data class Prop(
    @Json(name = "from")
    val from: From,
    @Json(name = "string")
    val string: String,
    @Json(name = "to")
    val to: To
)