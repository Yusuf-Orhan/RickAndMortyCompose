package com.yusuforhan.rickandmorty.presentation.characters

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
    fun getCharacters(){
        viewModelScope.launch {
            characters = repo.getCharacters().results
        }
    }
}