package com.example.rickandmortyimba.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyimba.App
import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.repositories.pagingsources.LocationPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

  fun fetchLocations(): Flow<PagingData<LocationModel>> {
      return Pager(
          config = PagingConfig(
              pageSize = 10,
              enablePlaceholders = false
          ),
          pagingSourceFactory = {
              LocationPagingSource(App.locationApiService!!)
          }).flow
  }


    fun fetchLocation(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        App.locationApiService?.fetchLocation(id)
            ?.enqueue(object : Callback<LocationModel> {
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