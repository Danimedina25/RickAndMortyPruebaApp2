package com.example.rickandmortypruebaapp.data.remote.repository

import android.util.Log
import com.example.openweatherapp.OpenWeatherFeature.domain.repository.RickAndMortyRepository
import com.example.rickandmortypruebaapp.data.mappers.toListCharacters
import com.example.rickandmortypruebaapp.data.remote.service.RickAndMortyApi
import com.example.rickandmortypruebaapp.domain.model.CharacterModel
import com.example.rickandmortypruebaapp.utils.NetworkResult
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RickAndMortyRepositoryImpl  @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
): RickAndMortyRepository {

    override suspend fun getCharacters(): Flow<NetworkResult<List<CharacterModel>>> = flow {
            try {
                val result = rickAndMortyApi.getCharacters(1).toListCharacters()
                emit(NetworkResult.Success(
                    data = result
                ))

            } catch (e: Exception) {
                emit(NetworkResult.Error(
                    message = "Unknown error",
                    data = null
                ))
            }
        }
    }