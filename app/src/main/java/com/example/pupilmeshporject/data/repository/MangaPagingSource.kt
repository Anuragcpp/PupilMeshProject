package com.example.pupilmeshporject.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pupilmeshporject.data.remote.apiService.ApiService
import com.example.pupilmeshporject.data.remote.dto.MangaData

class MangaPagingSource(
    private val apiService : ApiService
) : PagingSource<Int,MangaData> (){
    override fun getRefreshKey(state: PagingState<Int, MangaData>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaData> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getMangaData(page)
            //val manga = response.manga_list.map { it.toManga() }
            val manga = response.data
            LoadResult.Page(
                data = manga,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (manga.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}