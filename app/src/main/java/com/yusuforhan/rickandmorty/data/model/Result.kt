package com.yusuforhan.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    @SerializedName("image")
    val imageUrl: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

