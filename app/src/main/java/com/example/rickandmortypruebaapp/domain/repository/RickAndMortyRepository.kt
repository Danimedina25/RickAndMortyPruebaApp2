package com.example.openweatherapp.OpenWeatherFeature.domain.repository

import com.example.rickandmortypruebaapp.domain.model.CharacterModel
import com.example.rickandmortypruebaapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow


interface RickAndMortyRepository {
    fun getCharacters(): Flow<NetworkResult<List<CharacterModel>>>
}

