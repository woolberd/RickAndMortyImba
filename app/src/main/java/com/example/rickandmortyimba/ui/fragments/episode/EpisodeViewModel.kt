package com.example.rickandmortyimba.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.repositories.EpisodeRepository

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisodes() = episodeRepository.fetchEpisodes().cachedIn(viewModelScope)

    fun fetchEpisode(id: Int): MutableLiveData<EpisodeModel>{
        return episodeRepository.fetchEpisode(id)
    }
}