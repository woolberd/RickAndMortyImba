package com.example.rickandmortyimba.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchLocations() = locationRepository.fetchLocations()
//        .cachedIn(viewModelScope)

    fun getAll() = locationRepository.getAll()
}