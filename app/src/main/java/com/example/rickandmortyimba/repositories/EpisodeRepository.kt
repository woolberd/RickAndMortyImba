package com.example.rickandmortyimba.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyimba.App
import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.repositories.pagingsources.EpisodePagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    fun fetchEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSource(App.episodeApiService!!)
            }).flow
    }

    fun fetchEpisode(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        App.episodeApiService?.fetchEpisode(id)
            ?.enqueue(object : Callback<EpisodeModel> {
                override fun onResponse(
                    call: Call<EpisodeModel>,
                    response: Response<EpisodeModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<EpisodeModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}