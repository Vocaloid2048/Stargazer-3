/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import com.russhwolf.settings.Settings
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import utils.Black
import utils.BlackAlpha20
import utils.BlackAlpha80
import utils.Stargazer3Theme
import utils.Transparent
import utils.UtilTools
import utils.navigation.Screen


val gradient = Brush.verticalGradient(
    colors = listOf(
        BlackAlpha80,
        BlackAlpha20
    )
)
val gradientBottom = Brush.verticalGradient(
    colors = listOf(
        Transparent,
        Black
    )
)

lateinit var backgroundScreenHazeState : HazeState

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MakeBackground(modifier: Modifier = Modifier, screen: Screen) {
    backgroundScreenHazeState = remember { HazeState() }
    var isBlur = true;
    var isGradient = true;
    val backgroundImageBitmap = UtilTools().getAssetsWebpByFileName(
        UtilTools.ImageFolderType.BGS,
        Settings().getString("backgroundImage", "221000")
    );
    val backgroundImageByteArray = UtilTools().getAssetsURLByFileName(
        UtilTools.ImageFolderType.BGS,
        Settings().getString("backgroundImage", "221000")
    );
    //var backgroundBitmap = UtilTools().getAssetsWebpByContext(context = LocalContext.current, "images/${UtilTools.ImageFolderType.BGS.folderPath}1006.webp")
    when(screen){
        Screen.HomePage -> {isBlur = false;}
        Screen.BackgroundSettingScreen -> {isBlur = false;}
        Screen.MemoryOfChaosMissionPageScreen -> {isBlur = false; isGradient = false}
        Screen.PureFictionMissionPageScreen -> {isBlur = false; isGradient = false}
        else -> {}
    }
    Box(
        Modifier.haze(backgroundScreenHazeState)
    ){
        AsyncImage(
            model = UtilTools().newImageRequest(
                LocalPlatformContext.current,
                when(screen){
                    Screen.BackgroundSettingScreen -> UtilTools().getAssetsURLByFileName(UtilTools.ImageFolderType.BGS, "bg_light")
                    Screen.MemoryOfChaosMissionPageScreen -> UtilTools().getAssetsURLByFileName(UtilTools.ImageFolderType.BGS, "memory_of_chaos_bg")
                    Screen.PureFictionMissionPageScreen -> UtilTools().getAssetsURLByFileName(UtilTools.ImageFolderType.BGS, "pure_fiction_bg")
                    else -> backgroundImageByteArray
                }
            ),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(if (isBlur) 20.dp else 0.dp),
            imageLoader = UtilTools().newImageLoader(LocalPlatformContext.current)

        )
        /*
        Image(
            bitmap = when(screen){
                Screen.BackgroundSettingScreen -> UtilTools().getAssetsWebpByFileName(UtilTools.ImageFolderType.BGS, "bg_light")
                Screen.MemoryOfChaosMissionPageScreen -> UtilTools().getAssetsWebpByFileName(UtilTools.ImageFolderType.BGS, "memory_of_chaos_bg")
                Screen.PureFictionMissionPageScreen -> UtilTools().getAssetsWebpByFileName(UtilTools.ImageFolderType.BGS, "pure_fiction_bg")
                else -> backgroundImageBitmap
            },
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(if (isBlur) 20.dp else 0.dp)
        )
         */
        Box(
            modifier = Modifier.matchParentSize().background(
                if (isGradient) gradientBottom else Brush.linearGradient(listOf(Color.Transparent,Color.Transparent))
            )
        )
    }
}

@Preview
@Composable
fun GlobalBackgroundPreview() {
    Stargazer3Theme {
        MakeBackground(screen = Screen.HomePage)
    }
}