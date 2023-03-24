package com.example.rickandmortyimba.di

import com.example.rickandmortyimba.data.network.RetrofitClient
import com.example.rickandmortyimba.data.network.apiservices.CharacterApiService
import com.example.rickandmortyimba.data.network.apiservices.EpisodeApiService
import com.example.rickandmortyimba.data.network.apiservices.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiService(): CharacterApiService {
        return retrofitClient.provideCharacterApiService()
    }

    @Singleton
    @Provides
    fun provideEpisodeApiService(): EpisodeApiService {
        return retrofitClient.provideEpisodeApiService()
    }

    @Singleton
    @Provides
    fun provideLocationApiService(): LocationApiService {
        return retrofitClient.provideLocationApiService()
    }

}