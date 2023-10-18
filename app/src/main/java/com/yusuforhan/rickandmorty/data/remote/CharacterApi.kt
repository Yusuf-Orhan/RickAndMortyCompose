package com.yusuforhan.rickandmorty.data.remote


import com.yusuforhan.rickandmorty.common.Constants.CHARACTERS_ENDPOINT
import com.yusuforhan.rickandmorty.common.Constants.CHARACTER_ENDPOINT
import com.yusuforhan.rickandmorty.data.model.Characters
import com.yusuforhan.rickandmorty.data.model.Result
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {
    @GET(CHARACTERS_ENDPOINT)
    suspend fun getCharacters() : Characters
    @GET(CHARACTER_ENDPOINT)
    suspend fun getCharacter() : Result
}