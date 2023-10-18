package com.yusuforhan.rickandmorty.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(
    controller: NavController,id : Int,
    viewModel: DetailViewModel = hiltViewModel()
){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        viewModel.getDetail()
        Image(
            painter = rememberAsyncImagePainter(model = viewModel.character?.imageUrl),
            contentDescription = "Character Image",
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )
        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 14.dp, end = 14.dp)
        ){
            Text(
                text = viewModel.character?.name ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 20.dp),
                text = "Gender : \t ${viewModel.character?.gender}",
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                text = "Type : \t ${viewModel.character?.type ?: "Nullable"}",
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                text = "Location : \t ${viewModel.character?.location?.name}",
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                text = "Status : \t ${viewModel.character?.status}",
                fontSize = 18.sp
            )
        }
    }

}