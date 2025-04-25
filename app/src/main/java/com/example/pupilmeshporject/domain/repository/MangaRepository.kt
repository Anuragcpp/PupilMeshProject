package com.example.pupilmeshporject.domain.repository

import androidx.paging.PagingData
import com.example.pupilmeshporject.data.remote.dto.MangaData
import kotlinx.coroutines.flow.Flow

interface MangaRepository {
    fun getMangaPaged() : Flow<PagingData<MangaData>>
}