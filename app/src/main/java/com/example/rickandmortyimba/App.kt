package com.example.rickandmortyimba

import android.app.Application
import com.example.rickandmortyimba.data.network.RetrofitClient
import com.example.rickandmortyimba.data.network.apiservices.CharacterApiService
import com.example.rickandmortyimba.data.network.apiservices.EpisodeApiService
import com.example.rickandmortyimba.data.network.apiservices.LocationApiService

class App : Application() {

    companion object {
        val retrofitClient = RetrofitClient()
        var characterApiService: CharacterApiService? = null
        var episodeApiService: EpisodeApiService? = null
        var locationApiService: LocationApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiService = retrofitClient.provideCharacterApiService()
        episodeApiService = retrofitClient.provideEpisodeApiService()
        locationApiService = retrofitClient.provideLocationApiService()
    }
}