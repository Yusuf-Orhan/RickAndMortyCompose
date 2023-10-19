package com.yusuforhan.rickandmorty.presentation.characters

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yusuforhan.rickandmorty.R
import com.yusuforhan.rickandmorty.presentation.Screen
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.yusuforhan.rickandmorty.data.model.Result


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterScreen(controller: NavController,viewModel: CharactersViewModel = hiltViewModel()){

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        viewModel.getCharacters()
        if (viewModel.isLoading){
            CircularProgressIndicator()
        }else if (viewModel.isErrorMessage.isNotEmpty()){
            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = viewModel.isErrorMessage)
            }
        } else if (viewModel.characters.isNotEmpty()){
            LazyColumn{
                items(viewModel.characters){result ->
                    CharacterListItem(result = result, imageUrl = result.imageUrl ,controller)
                }
            }
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListItem(result: Result,imageUrl : String,controller: NavController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 5.dp),
        onClick = {
            controller.navigate(Screen.Detail.sendId(result.id))
            println("Id : ${result.id}")
        }) {
        Row (verticalAlignment = Alignment.CenterVertically){
            AsyncImage(model = imageUrl, contentDescription = "")
            Text(text = result.name, modifier = Modifier.padding(10.dp))
        }

    }
}
