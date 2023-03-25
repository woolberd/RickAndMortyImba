package com.example.rickandmortyimba.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.rickandmortyimba.data.db.daos.CharacterDao
import com.example.rickandmortyimba.data.db.daos.EpisodeDao
import com.example.rickandmortyimba.data.db.daos.LocationDao
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.models.EpisodeModel
import com.example.rickandmortyimba.models.LocationModel
import com.example.rickandmortyimba.utils.CharacterConverter

@Database(entities = [CharacterModel::class, EpisodeModel::class, LocationModel::class], version = 2)
@TypeConverters(CharacterConverter::class)
abstract class AppDatabase: RoomDatabase(){

    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
}