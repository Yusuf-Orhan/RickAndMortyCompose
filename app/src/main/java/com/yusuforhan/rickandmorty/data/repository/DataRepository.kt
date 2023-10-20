package com.yusuforhan.rickandmorty.data.repository


import android.accounts.NetworkErrorException
import androidx.compose.runtime.*
import com.yusuforhan.rickandmorty.data.model.Result
import com.yusuforhan.rickandmorty.data.remote.CharacterApi
import com.yusuforhan.rickandmorty.utils.Resource
import java.io.IOError
import javax.inject.Inject

class DataRepository @Inject constructor(private val api : CharacterApi) {
    var result by mutableStateOf<List<Result>>(listOf())
    suspend fun getCharacters(): Resource<List<Result>>{
        result = try {
            api.getCharacters().results
        }catch (e : NetworkErrorException){
            return Resource.Error("Internet Error")
        }catch (e : IOError){
            return Resource.Error("Io Error")
        }catch (e : Exception){
            return Resource.Error("${e.message}")
        }

        return Resource.Success(result)
    }
    suspend fun getCharacterDetail(id : Int) : Result{
        return api.getCharacter(id)
    }
}