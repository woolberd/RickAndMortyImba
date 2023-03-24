package com.example.rickandmortyimba.data.network.apiservices

import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    fun fetchLocations(
//        @Query("page") page : Int
    ): Call <RickAndMortyResponse<LocationModel>>

    @GET("api/location/{id}")
    fun fetchLocation(
        @Path("id") id : Int
    ): Call<LocationModel>
}