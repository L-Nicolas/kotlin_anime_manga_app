package com.example.kotlinanimemangaapp.presentation

import com.example.kotlinanimemangaapp.common.Resource
import com.example.kotlinanimemangaapp.di.AppModule.provideMangaApi
import com.example.kotlinanimemangaapp.di.AppModule.provideMangaRepository
import com.example.kotlinanimemangaapp.domain.interactor.get_mangas.GetMangasUC
import kotlinx.coroutines.runBlocking

class App {
    fun main() {
        runBlocking {
            val mangaApi = provideMangaApi()
            val mangaRepository = provideMangaRepository(mangaApi)

            val mangaFlow = GetMangasUC(mangaRepository).invoke()

            mangaFlow.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        println("Loading...")
                    }
                    is Resource.Success -> {
                        println(resource.data?.toString())
                    }
                    is Resource.Error -> {
                        println(resource.message)
                    }
                }
            }
        }
    }
}

fun main() {
    App().main()
}
