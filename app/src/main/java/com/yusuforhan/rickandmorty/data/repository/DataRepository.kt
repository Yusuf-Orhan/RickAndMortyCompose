package com.yusuforhan.rickandmorty.data.repository


import com.yusuforhan.rickandmorty.data.model.Characters
import com.yusuforhan.rickandmorty.data.model.Result
import com.yusuforhan.rickandmorty.data.remote.CharacterApi
import com.yusuforhan.rickandmorty.utils.Resource
import javax.inject.Inject

class DataRepository @Inject constructor(private val api : CharacterApi) {
    suspend fun getCharacters(): Characters{
        return api.getCharacters()
    }
    suspend fun getCharacterDetail() : Result{
        return api.getCharacter()
    }
}