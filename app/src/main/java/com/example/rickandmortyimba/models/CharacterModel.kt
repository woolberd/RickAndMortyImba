package com.example.rickandmortyimba.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("status")
    val status: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("gender")
    val gender: String
)
