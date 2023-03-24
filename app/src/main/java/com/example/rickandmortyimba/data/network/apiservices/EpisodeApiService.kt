package com.example.rickandmortyimba.data.network.apiservices

import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisodes(
//        @Query("page") page : Int
    ): Call <RickAndMortyResponse<EpisodeModel>>

    @GET("api/episode/{id}")
    fun fetchEpisode(
        @Path("id") id : Int
    ): Call<EpisodeModel>
}