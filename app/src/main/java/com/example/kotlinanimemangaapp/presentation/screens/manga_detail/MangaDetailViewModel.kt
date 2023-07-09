package com.example.kotlinanimemangaapp.presentation.screens.manga_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinanimemangaapp.common.Resource
import com.example.kotlinanimemangaapp.domain.interactor.get_mangas.GetMangasUC
import com.example.kotlinanimemangaapp.presentation.screens.home.MangaListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private val getMangaUC: GetMangasUC
) : ViewModel() {

    private val _state = mutableStateOf(MangaDetailState())
    val state: State<MangaDetailState> = _state

    init {
        getManga(1)
    }

    private fun getManga(mangaId: Int) {
        getMangaUC(mangaId).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _state.value = MangaDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MangaDetailState(manga = resource.data)
                }
                is Resource.Error -> {
                    _state.value = MangaDetailState(error = resource.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}