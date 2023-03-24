package com.example.rickandmortyimba.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.repositories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun fetchEpisodes() = episodeRepository.fetchEpisodes()
//        .cachedIn(viewModelScope)

    fun getAll() = episodeRepository.getAll()
}