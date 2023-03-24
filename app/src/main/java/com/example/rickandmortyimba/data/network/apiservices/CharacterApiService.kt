package com.example.rickandmortyimba.data.network.apiservices

import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
   fun fetchCharacters(
//        @Query("page") page : Int
    ): Call <RickAndMortyResponse<CharacterModel>>

   @GET("api/character/{id}")
    fun fetchCharacter(
       @Path("id") id : Int
    ): Call<CharacterModel>
}