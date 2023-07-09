package com.example.kotlinanimemangaapp.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinanimemangaapp.common.Resource
import com.example.kotlinanimemangaapp.domain.interactor.get_mangas.GetMangasUC
import com.google.api.ResourceProto.resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MangaListViewModel @Inject constructor(
    private val getMangaUC: GetMangasUC
) : ViewModel() {

    private val _state = mutableStateOf(MangaListState())
    val state: State<MangaListState> = _state

    init {
        getMangas()
    }

    private fun getMangas() {
        getMangaUC().onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _state.value = MangaListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MangaListState(mangas = resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MangaListState(error = resource.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}