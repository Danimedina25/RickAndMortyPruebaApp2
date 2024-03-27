package com.example.rickandmortypruebaapp.ui.ListOfCharacters

import com.example.rickandmortypruebaapp.domain.model.CharacterModel

data class ListOfCharactersState(
    val characters: List<CharacterModel> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false
)
