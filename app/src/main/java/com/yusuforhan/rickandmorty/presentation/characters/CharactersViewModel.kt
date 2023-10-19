package com.yusuforhan.rickandmorty.presentation.characters

import com.yusuforhan.rickandmorty.utils.Resource
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuforhan.rickandmorty.data.model.Result
import com.yusuforhan.rickandmorty.data.repository.DataRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repo : DataRepository
): ViewModel() {
    var characters by  mutableStateOf<List<Result>>(listOf())
    var isErrorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(true)

    fun getCharacters(){
        viewModelScope.launch {
            val result = repo.getCharacters()
            if (result is Resource.Success){
                characters = result.data ?: listOf()
                isLoading = false
            }else if (result is Resource.Error){
                isErrorMessage = result.message ?: "Null Error Message"
                isLoading = false
            }
        }

    }
}