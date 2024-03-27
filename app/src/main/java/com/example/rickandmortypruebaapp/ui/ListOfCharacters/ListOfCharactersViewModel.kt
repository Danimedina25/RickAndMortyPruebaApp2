package com.example.rickandmortypruebaapp.ui.ListOfCharacters

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmortypruebaapp.domain.model.CharacterModel
import com.example.rickandmortypruebaapp.domain.usecases.GetCharactersUseCase
import com.example.rickandmortypruebaapp.utils.NetworkResult
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListOfCharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {


    private val _getCharactersResult = MutableStateFlow<List<CharacterModel>>(
       emptyList())
    val getCharactersResult: StateFlow<List<CharacterModel>>
        get() = _getCharactersResult


    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            getCharactersUseCase().onEach {
                _getCharactersResult.emit(it.data!!)
            }.launchIn(this)

        }
    }

}