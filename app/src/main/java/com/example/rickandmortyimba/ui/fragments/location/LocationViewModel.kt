package com.example.rickandmortyimba.ui.fragments.location

import androidx.lifecycle.ViewModel
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