/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.screen.ui.theme.BlackAlpha20
import com.voc.honkai_stargazer.screen.ui.theme.BlackAlpha80
import com.voc.honkai_stargazer.screen.ui.theme.Stargazer3Theme
import com.voc.honkai_stargazer.util.Screen
import com.voc.honkai_stargazer.util.UtilTools
import dev.chrisbanes.haze.HazeState


val gradient = Brush.verticalGradient(
    colors = listOf(
        BlackAlpha20,
        BlackAlpha80
    )
)

enum class BackgroundDisplayEnum{
    DEFAULT,    //用戶選擇的背景（原圖）
    BLUR,       //用戶選擇的背景（模糊化）
    MOC,        //混沌回憶的背景
    PF,         //虛構敘事的背景
}

@Composable
fun MakeBackground(modifier: Modifier = Modifier, screen: Screen) {
    val hazeState = remember { HazeState() }
    var isBlur = true;
    var backgroundBitmap = UtilTools().getAssetsWebpByContext(context = LocalContext.current, "images/${UtilTools.ImageFolderType.BGS.folderPath}221000.webp")
    when(screen){
        Screen.HomePage -> {isBlur = false;}
        else -> {}
    }
    Box{
        Image(
            bitmap = backgroundBitmap.asImageBitmap(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(0.dp)
        )
        Box(modifier = Modifier.matchParentSize().background(gradient))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GlobalBackgroundPreview() {
    Stargazer3Theme {
        MakeBackground(screen = Screen.HomePage)
    }
}