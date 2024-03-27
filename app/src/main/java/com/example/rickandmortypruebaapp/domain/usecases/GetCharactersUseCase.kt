package com.example.rickandmortypruebaapp.domain.usecases

import android.util.Log
import com.example.openweatherapp.OpenWeatherFeature.domain.repository.RickAndMortyRepository
import com.example.rickandmortypruebaapp.domain.model.CharacterModel
import com.example.rickandmortypruebaapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: RickAndMortyRepository) {

    suspend operator fun invoke(): Flow<NetworkResult<List<CharacterModel>>> {
        return repository.getCharacters()
    }
}