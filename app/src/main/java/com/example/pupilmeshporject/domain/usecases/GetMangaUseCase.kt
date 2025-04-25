package com.example.pupilmeshporject.domain.usecases

import androidx.paging.PagingData
import com.example.pupilmeshporject.data.remote.dto.MangaData
import com.example.pupilmeshporject.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMangaUseCase @Inject constructor(
    private val repository: MangaRepository
) {
    operator fun invoke() : Flow<PagingData<MangaData>> = repository.getMangaPaged()
}