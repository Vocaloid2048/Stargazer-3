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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.screen.ui.theme.BlackAlpha20
import com.voc.honkai_stargazer.screen.ui.theme.BlackAlpha80
import com.voc.honkai_stargazer.screen.ui.theme.Stargazer3Theme


val gradient = Brush.verticalGradient(
    colors = listOf(
        BlackAlpha20,
        BlackAlpha80
    )
)

@Composable
fun MakeBackground(modifier: Modifier = Modifier) {
    Box{
        Image(
            painterResource(R.drawable.test_bg),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(modifier = Modifier.matchParentSize().background(gradient))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GlobalBackgroundPreview() {
    Stargazer3Theme {
        MakeBackground()
    }
}