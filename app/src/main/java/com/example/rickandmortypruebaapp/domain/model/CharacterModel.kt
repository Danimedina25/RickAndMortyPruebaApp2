package com.example.rickandmortypruebaapp.domain.model

import com.example.rickandmortypruebaapp.data.remote.service.response.LocationDto
import com.example.rickandmortypruebaapp.data.remote.service.response.OriginDto

data class CharacterModel(
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
)
