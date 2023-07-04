package com.example.kotlinanimemangaapp.domain.interactor.get_mangas

import com.example.kotlinanimemangaapp.common.Resource
import com.example.kotlinanimemangaapp.domain.model.Manga
import com.example.kotlinanimemangaapp.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetMangasUC @Inject constructor(
    private val mangaRepository: MangaRepository
) {
    operator fun invoke(): Flow<Resource<Manga>> = flow {
        val manga = mangaRepository.getManga()
        if (manga == null) {
            emit(Resource.Error(message = "No data found"))
        } else {
            emit(Resource.Success(manga))
        }
    }.onStart { emit(Resource.Loading()) }
        .catch { e -> emit(Resource.Error(message = "Error with ${e.localizedMessage}")) }
}
