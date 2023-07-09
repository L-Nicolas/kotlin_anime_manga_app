package com.example.kotlinanimemangaapp.domain.interactor

import androidx.lifecycle.ViewModel
import com.example.kotlinanimemangaapp.domain.interactor.get_mangas.GetMangasUC
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataInteractor @Inject constructor(
    private val getMangaUC: GetMangasUC
) : ViewModel() {

}

