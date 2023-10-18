package com.yusuforhan.rickandmorty.presentation

import com.yusuforhan.rickandmorty.common.Constants.DETAIL_ARGUMENT_KEY

sealed class Screen(val route : String){

    object Character : Screen(route = "character_screen")

    object Detail : Screen(route = "detail_screen/{${DETAIL_ARGUMENT_KEY}}"){
        fun sendId(id : Int) : String = "detail_screen/$id"
    }
}
