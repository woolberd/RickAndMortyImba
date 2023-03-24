package com.example.rickandmortyimba.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.models.EpisodeModel

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episodeModel")
    fun getAll(): LiveData<List<EpisodeModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(episodeModel: List<EpisodeModel>)
}
