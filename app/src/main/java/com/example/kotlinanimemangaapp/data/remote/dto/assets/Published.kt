package com.example.kotlinanimemangaapp.data.remote.dto.assets


import com.squareup.moshi.Json

data class Published(
    @Json(name = "from")
    val from: String,
    @Json(name = "prop")
    val prop: Prop,
    @Json(name = "to")
    val to: String
)