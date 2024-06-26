package com.example.rickandmortypruebaapp.ui.ListOfCharacters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmortypruebaapp.R
import com.example.rickandmortypruebaapp.domain.model.CharacterModel
import com.example.rickandmortypruebaapp.ui.Greeting
import com.example.rickandmortypruebaapp.ui.theme.RickAndMortyPruebaAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfCharactersScreen(viewModel: ListOfCharactersViewModel = hiltViewModel()){
    val characters = viewModel.getCharactersResult.collectAsState()
    val loading = viewModel.isLoading.collectAsState()
    RickAndMortyPruebaAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    CharactersTopBar()
                },
            ) { innerPadding ->
                CharactersContent(
                    modifier = Modifier.padding(innerPadding),
                    isLoading = loading.value,
                    characters = characters.value
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CharactersTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        Modifier.background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
private fun CharactersContent(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    characters: List<CharacterModel> = emptyList()
) {

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {

        if (isLoading)
            Loading()
        else
            LazyColumn(
                contentPadding = PaddingValues(vertical = 6.dp),
                modifier = Modifier.fillMaxWidth(),
                content = {
                    items(characters.size) { index ->
                        CharacterItem(
                            modifier = Modifier.fillMaxWidth(),
                            item = characters[index],
                        )
                    }
                }
            )
    }
}



@Composable
private fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
    }
}

