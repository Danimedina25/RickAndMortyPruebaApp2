package com.example.openweatherapp.di

import com.example.openweatherapp.OpenWeatherFeature.domain.repository.RickAndMortyRepository
import com.example.rickandmortypruebaapp.data.remote.repository.RickAndMortyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindOpenWeatherRepository(
        randomUserRepositoryImpl: RickAndMortyRepositoryImpl
    ): RickAndMortyRepository

}