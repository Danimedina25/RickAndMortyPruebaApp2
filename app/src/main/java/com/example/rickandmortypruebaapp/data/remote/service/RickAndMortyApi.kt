package com.example.rickandmortypruebaapp.data.remote.service

import com.example.rickandmortypruebaapp.data.remote.service.response.ApiResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("/api/character/")
    suspend fun getCharacters(@Query("page") page: Int): ApiResponseDto

}
