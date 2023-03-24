package com.example.rickandmortyimba.ui.fragments.location.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel@Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchLocation(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchLocation(id)
    }
}