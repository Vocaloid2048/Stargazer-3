package com.voc.honkai_stargazer.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.component.ListHeader
import com.voc.honkai_stargazer.screen.ui.theme.Stargazer3Theme
import com.voc.honkai_stargazer.util.RootContent

@Composable
fun CharacterListPage(modifier: Modifier = Modifier, navController : NavController) {
    Box(modifier = Modifier){
        //LazyVerticalGrid(columns = , content = )
        ListHeader(navController = navController)
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CharacterListPagePreview() {
    RootContent(navController = rememberNavController(), page = { CharacterListPage(navController = rememberNavController()) })
}