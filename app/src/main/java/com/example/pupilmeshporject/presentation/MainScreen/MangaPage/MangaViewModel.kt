package com.example.pupilmeshporject.presentation.MainScreen.MangaPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pupilmeshporject.domain.usecases.GetMangaUseCase
import javax.inject.Inject

class MangaViewModel @Inject constructor(
    private val getMangaUseCase: GetMangaUseCase
) : ViewModel() {
    val mangaPagingFlow = getMangaUseCase().cachedIn(viewModelScope)
}