package com.example.rickandmortyimba.data.network.apiservices

import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>
}