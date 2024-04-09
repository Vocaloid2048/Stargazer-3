/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.screen.ui.theme.FontSizeNormal
import com.voc.honkai_stargazer.screen.ui.theme.TextColorLevel
import com.voc.honkai_stargazer.screen.ui.theme.TextColorNormal
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild

val LISTHEADER_HEIGHT = 64.dp

enum class BackIcon(var id: Int) {
    BACK(id = R.drawable.ui_icon_back),
    CANCEL(id = R.drawable.ui_icon_close)
}

@Composable
fun ListHeader(
    navController: NavController = rememberNavController(),
    onBack: ((navController: NavController) -> Unit) = { navController: NavController -> navController.popBackStack() },
    backIconId: BackIcon = BackIcon.BACK,
    onForward: (() -> Unit) = {},
    forwardIconId: Int = R.drawable.bg_transparent,
    title: String = "?",
    titleIconId: Int = R.drawable.phorphos_sun_dim_fill,
    //hazeState: HazeState = HazeState()
) {
    //Background
    Box(
        Modifier
            .background(Color(0x66FFFFFF))
            .statusBarsPadding()
            .requiredHeight(LISTHEADER_HEIGHT)
        /*
            .hazeChild(
                state = hazeState,
                shape = RoundedCornerShape(16.dp),
                style = HazeStyle(Color.Unspecified, 20.dp, Float.MIN_VALUE)
            )
         */
    ) {
        //BlurView can place in there
        //Now will use Pure Color Background
        Row(
            Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            OutlinedButton(
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically),
                onClick = { onBack(navController) },
                border = BorderStroke(0.dp, Color(0x00FFFFFF))
            ) {
                Image(
                    painter = painterResource(id = backIconId.id),
                    contentDescription = "Back Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically),
                    colorFilter = ColorFilter.tint(Color.White),

                    )
            }
            Column(
                Modifier.weight(1f).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = titleIconId),
                    contentDescription = "Title Icon",
                    modifier = Modifier.size(32.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Row {
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .width(50.dp)
                            .background(Color(0x66FFFFFF))
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = title,
                        color = TextColorNormal,
                        style = FontSizeNormal,
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .width(50.dp)
                            .background(Color(0x66FFFFFF))
                            .align(Alignment.CenterVertically),
                    )
                }

            }
            OutlinedButton(
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically),
                onClick = { onForward },
                border = BorderStroke(0.dp, Color(0x00FFFFFF))
            ) {
                Image(
                    painter = painterResource(id = forwardIconId),
                    contentDescription = "Forward Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically),
                    colorFilter = ColorFilter.tint(Color.White),

                    )
            }
        }
    }
}

@Preview()
@Composable
fun ListHeaderPreview() {
    ListHeader(rememberNavController())
}