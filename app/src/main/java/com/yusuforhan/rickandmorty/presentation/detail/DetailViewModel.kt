package com.yusuforhan.rickandmorty.presentation.detail

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuforhan.rickandmorty.data.model.Result
import com.yusuforhan.rickandmorty.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repo : DataRepository
): ViewModel(){

    var character by mutableStateOf<Result?>(null)

    fun getDetail() : Result? {
        viewModelScope.launch {
            character = repo.getCharacterDetail()
        }
        return character
    }
}