package com.yusuforhan.rickandmorty.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yusuforhan.rickandmorty.R
import com.yusuforhan.rickandmorty.common.Constants.DETAIL_ARGUMENT_KEY
import com.yusuforhan.rickandmorty.presentation.characters.CharacterScreen
import com.yusuforhan.rickandmorty.presentation.characters.CharactersViewModel
import com.yusuforhan.rickandmorty.presentation.detail.DetailScreen
import com.yusuforhan.rickandmorty.presentation.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                Column {
                    Scaffold (topBar = {
                        TopAppBar(
                            title = { Text(
                                text = stringResource(id = R.string.app_name),
                                color = colorResource(id = R.color.white))},
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
                        )
                    }){
                        it.calculateBottomPadding()
                        NavGraph()
                    }
                }


            }
        }
    }

    @Composable
    fun NavGraph() {
        val controller = rememberNavController()
        Column (modifier = Modifier.padding(top = 70.dp)){
            NavHost(navController = controller, startDestination = Screen.Character.route) {
                composable(
                    route = Screen.Character.route
                ){
                    CharacterScreen(controller = controller)
                }
                composable(
                    route = Screen.Detail.route,
                    arguments = listOf(
                        navArgument(name = DETAIL_ARGUMENT_KEY){
                            type = NavType.IntType
                            defaultValue = 100
                        }
                    )
                ){
                    DetailScreen(controller = controller, id = it.arguments?.getInt(DETAIL_ARGUMENT_KEY) ?: 100)
                }
            }
        }

    }
}