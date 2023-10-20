package com.yusuforhan.rickandmorty.data.remote


import com.yusuforhan.rickandmorty.common.Constants.CHARACTERS_ENDPOINT
import com.yusuforhan.rickandmorty.data.model.Characters
import com.yusuforhan.rickandmorty.data.model.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {
    @GET(CHARACTERS_ENDPOINT)
    suspend fun getCharacters() : Characters
    @GET("/api/character/{id}")
    suspend fun getCharacter(@Path("id")id : Int) : Result
}