package com.example.rickandmortypruebaapp.data.mappers

import com.example.rickandmortypruebaapp.data.remote.service.response.ApiResponseDto
import com.example.rickandmortypruebaapp.domain.model.CharacterModel

fun ApiResponseDto.toListCharacters(): List<CharacterModel> {
    val listOfCharacters = results.mapIndexed { _, character ->
        CharacterModel(
            id = character.id,
            name = character.name,
            species = character.species,
            image = character.image,
            origin = character.origin,
            status = character.status,
            type = character.type,
            gender = character.gender,
            location = character.location
        )
    }
    return listOfCharacters
}