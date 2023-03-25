package com.example.rickandmortyimba.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyimba.data.db.daos.LocationDao
import com.example.rickandmortyimba.data.network.apiservices.LocationApiService
import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApiService,
    private val locationDao: LocationDao
) {

    fun fetchLocations(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()
        locationApiService.fetchLocations()
            .enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> locationDao.insertAll(it1.results) }
                        }
                    }
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<LocationModel>> {
        return locationDao.getAll()
    }

//  fun fetchLocations(): Flow<PagingData<LocationModel>> {
//      return Pager(
//          config = PagingConfig(
//              pageSize = 10,
//              enablePlaceholders = false
//          ),
//          pagingSourceFactory = {
//              LocationPagingSource(App.locationApiService!!)
//          }).flow
//  }


    fun fetchLocation(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        locationApiService.fetchLocation(id)
            .enqueue(object : Callback<LocationModel> {
                override fun onResponse(
                    call: Call<LocationModel>,
                    response: Response<LocationModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<LocationModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}