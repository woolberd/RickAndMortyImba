package com.example.rickandmortyimba.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyimba.data.db.daos.CharacterDao
import com.example.rickandmortyimba.data.network.apiservices.CharacterApiService
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiService: CharacterApiService,
    private val characterDao: CharacterDao
) {

    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()
        characterApiService.fetchCharacters()
            .enqueue(object : Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    if (response.body() != null){
                        response.body().let {
                            it?.let { it1 -> characterDao.insertAll(it1.results) }
                        }
                    }
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<CharacterModel>>{
        return characterDao.getAll()
    }


//    fun fetchCharacters(): Flow<PagingData<CharacterModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                CharacterPagingSource(App.characterApiService!!)
//            }).flow
//    }

    fun fetchCharacter(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        characterApiService.fetchCharacter(id)
            .enqueue(object : Callback<CharacterModel> {
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

