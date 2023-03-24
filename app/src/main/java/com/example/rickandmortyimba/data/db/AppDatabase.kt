package com.example.rickandmortyimba.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyimba.data.db.daos.CharacterDao
import com.example.rickandmortyimba.data.db.daos.EpisodeDao
import com.example.rickandmortyimba.data.db.daos.LocationDao
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.models.LocationModel

@Database(entities = [CharacterModel::class, EpisodeModel::class, LocationModel::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
}