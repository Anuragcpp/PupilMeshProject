package com.example.pupilmeshporject.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pupilmeshporject.data.remote.apiService.ApiService
import com.example.pupilmeshporject.data.remote.dto.MangaData
import com.example.pupilmeshporject.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MangaRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : MangaRepository {

    override fun getMangaPaged(): Flow<PagingData<MangaData>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MangaPagingSource(apiService)}
        ).flow
    }

}