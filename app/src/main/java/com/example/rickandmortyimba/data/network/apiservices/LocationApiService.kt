package com.example.rickandmortyimba.data.network.apiservices

import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>
}