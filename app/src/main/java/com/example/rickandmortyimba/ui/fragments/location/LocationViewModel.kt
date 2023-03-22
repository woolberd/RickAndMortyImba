package com.example.rickandmortyimba.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.repositories.LocationRepository

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocations() = locationRepository.fetchLocations().cachedIn(viewModelScope)

    fun fetchLocation(id: Int): MutableLiveData<LocationModel>{
        return locationRepository.fetchLocation(id)
    }
}