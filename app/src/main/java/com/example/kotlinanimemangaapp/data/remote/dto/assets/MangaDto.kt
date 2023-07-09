package com.example.kotlinanimemangaapp.data.remote.dto.assets

import com.example.kotlinanimemangaapp.domain.model.Manga
import com.squareup.moshi.Json

data class MangaDto(
    @Json(name = "approved")
    val approved: Boolean,
    @Json(name = "authors")
    val authors: List<Author>,
    @Json(name = "background")
    val background: String,
    @Json(name = "chapters")
    val chapters: Int?,
    @Json(name = "demographics")
    val demographics: List<Demographic>?,
    @Json(name = "explicit_genres")
    val explicitGenres: List<ExplicitGenre>?,
    @Json(name = "favorites")
    val favorites: Int,
    @Json(name = "genres")
    val genres: List<Genre>,
    @Json(name = "images")
    val images: Images,
    @Json(name = "mal_id")
    val malId: Int,
    @Json(name = "members")
    val members: Int,
    @Json(name = "popularity")
    val popularity: Int,
    /*@Json(name = "published")
    val published: Published,*/
    @Json(name = "publishing")
    val publishing: Boolean,
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "score")
    val score: Float,
    @Json(name = "scored_by")
    val scoredBy: Int,
    @Json(name = "serializations")
    val serializations: List<Serialization>,
    @Json(name = "status")
    val status: String,
    @Json(name = "synopsis")
    val synopsis: String?,
    @Json(name = "themes")
    val themes: List<Theme>?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "title_english")
    val titleEnglish: String?,
    @Json(name = "title_japanese")
    val titleJapanese: String?,
    @Json(name = "titles")
    val titles: List<Title>,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "volumes")
    val volumes: Int?
)

fun MangaDto.toManga(): Manga = Manga(
    id = malId ?: 0,
    title = title ?: "",
    popularity = popularity ?: 0,
    image_url = images.jpg.imageUrl ?: ""
)