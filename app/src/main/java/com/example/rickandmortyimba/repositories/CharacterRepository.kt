package com.example.rickandmortyimba.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyimba.App
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.repositories.pagingsources.CharacterPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    fun fetchCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(App.characterApiService!!)
            }).flow
    }

    fun fetchCharacter(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiService?.fetchCharacter(id)
            ?.enqueue(object : Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<CharacterModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}