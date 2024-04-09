/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.voc.honkai_stargazer.screen.HomePage
import com.voc.honkai_stargazer.screen.ui.theme.Stargazer3Theme
import com.voc.honkai_stargazer.util.Navigation
import com.voc.honkai_stargazer.util.RootContent
import com.voc.honkai_stargazer.util.Screen

class MainActivity : ComponentActivity() {
    private lateinit var activity: Activity
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //val systemUiController = rememberSystemUiController()

            Navigation()
        }
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            )
        )
        activity = this;
        context = this;
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityPreview() {
    Stargazer3Theme {
        RootContent(screen = Screen.HomePage, navController = rememberNavController(), page = {HomePage(navController = rememberNavController())})
    }
}