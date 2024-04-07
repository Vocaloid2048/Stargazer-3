package com.voc.honkai_stargazer.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.constants.Constants
import com.voc.honkai_stargazer.screen.CharacterListPage
import com.voc.honkai_stargazer.screen.HomePage
import com.voc.honkai_stargazer.screen.MakeBackground

sealed class Screen(val route: String){
    object HomePage : Screen("HomeScreen")
    object CharacterListPage  : Screen("CharacterListPage")
}
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomePage.route){
        composable(route = Screen.HomePage.route){
            RootContent(navController = navController, page = { HomePage(navController = navController) })
        }
        composable(route = Screen.CharacterListPage.route){
            RootContent(navController = navController, page = { CharacterListPage(navController = navController) })
        }
    }
}

@Composable
fun RootContent(modifier: Modifier = Modifier, navController: NavController, page : @Composable () -> Unit){
    Box{
        MakeBackground()
        //Landscape can do ... ?
        Box(modifier = Modifier
            .statusBarsPadding()
            //.navigationBarsPadding()
        ){
            page()
        }
    }
}