package com.example.rickandmortyimba.models

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("created")
    val created: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val airDate: String,

    @SerializedName("episode")
    val episode: String
)
