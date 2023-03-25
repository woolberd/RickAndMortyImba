package com.example.rickandmortyimba.ui.fragments.episode

import androidx.lifecycle.ViewModel
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