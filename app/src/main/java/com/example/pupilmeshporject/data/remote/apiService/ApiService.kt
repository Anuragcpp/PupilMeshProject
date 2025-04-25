package com.example.pupilmeshporject.data.remote.apiService

import com.example.pupilmeshporject.data.remote.dto.ApiResponsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // demo api end point
    @GET("/manga")
    suspend fun getMangaData(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ) : ApiResponsDTO
}