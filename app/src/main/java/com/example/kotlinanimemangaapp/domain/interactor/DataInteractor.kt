package com.example.kotlinanimemangaapp.domain.interactor

import com.example.kotlinanimemangaapp.domain.interactor.get_mangas.GetMangasUC
import javax.inject.Inject

data class DataInteractor @Inject constructor(
    val getMangaUC: GetMangasUC
)
