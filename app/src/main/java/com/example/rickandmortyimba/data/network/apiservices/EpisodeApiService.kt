package com.example.rickandmortyimba.data.network.apiservices

import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisode(): retrofit2.Call<RickAndMortyResponse<EpisodeModel>>
}