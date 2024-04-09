/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.util

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.component.HeaderData
import com.voc.honkai_stargazer.component.defaultHeaderData
import com.voc.honkai_stargazer.screen.CharacterListPage
import com.voc.honkai_stargazer.screen.HomePage
import com.voc.honkai_stargazer.screen.LightconeListPage
import com.voc.honkai_stargazer.screen.MakeBackground

sealed class Screen(val route: String, val headerData: HeaderData = defaultHeaderData){
    object HomePage : Screen("HomeScreen" , HeaderData("首頁", R.drawable.phorphos_house_fill))
    object CharacterListPage  : Screen("CharacterListPage",HeaderData("角色列表", R.drawable.phorphos_person_fill))
    object LightconeListPage  : Screen("LightconeListPage",HeaderData("光錐列表", R.drawable.phorphos_sword_fill))
    object RelicListPage  : Screen("RelicListPage",HeaderData("遺器列表", R.drawable.phorphos_baseball_cap_fill))
}
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomePage.route){
        composable(route = Screen.HomePage.route, enterTransition = { EnterTransition.None} , exitTransition = { ExitTransition.None }){
            RootContent(screen = Screen.HomePage, navController = navController, page = { HomePage(navController = navController, headerData = Screen.HomePage.headerData) })
        }
        composable(route = Screen.CharacterListPage.route, enterTransition = { EnterTransition.None} , exitTransition = { ExitTransition.None }){
            RootContent(screen = Screen.CharacterListPage, navController = navController, page = { CharacterListPage(navController = navController, headerData = Screen.CharacterListPage.headerData) })
        }
        composable(route = Screen.LightconeListPage.route, enterTransition = { EnterTransition.None} , exitTransition = { ExitTransition.None }){
            RootContent(screen = Screen.LightconeListPage, navController = navController, page = { LightconeListPage(navController = navController, headerData = Screen.LightconeListPage.headerData) })
        }
    }
}

@Composable
fun RootContent(screen : Screen, modifier: Modifier = Modifier, navController: NavController, page : @Composable () -> Unit){
    Box{
        MakeBackground(screen = screen)
        //Landscape can do ... ?
        Box(modifier = Modifier
        ){
            page()
        }
    }
}