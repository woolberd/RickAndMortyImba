package com.example.rickandmortyimba.ui.fragments.episode.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.repositories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun fetchEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchEpisode(id)
    }
}