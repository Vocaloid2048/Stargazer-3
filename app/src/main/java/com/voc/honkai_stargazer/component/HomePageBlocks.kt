/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.component

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.screen.ui.theme.BlackAlpha20
import com.voc.honkai_stargazer.screen.ui.theme.BlackAlpha80
import com.voc.honkai_stargazer.screen.ui.theme.FontSizeNormal16
import com.voc.honkai_stargazer.screen.ui.theme.FontSizeNormalLarge
import com.voc.honkai_stargazer.screen.ui.theme.FontSizeNormalSmall
import com.voc.honkai_stargazer.screen.ui.theme.Stargazer3Theme
import com.voc.honkai_stargazer.screen.ui.theme.TextColorNormal
import com.voc.honkai_stargazer.util.Screen

class HomePageBlocks {
    class HomePageBlockItem(
        var itemTitle: String = "",
        var itemIconId: Int = R.drawable.phorphos_cake_fill,
        var itemType: HomePageBlockItemType = HomePageBlockItemType.W1H1,
        var itemTopHighlight: String? = "",
        var itemTop: String? = "",
        var itemBottom: String? = "",
        var itemOnClickAction: (() -> Unit)? = null,
        var itemOnClickToNavigate: Screen? = null,
    ) {
        enum class HomePageBlockItemType(val width: Int, val height: Int) {
            W1H1( 1, 1), W2H1(2, 1)
        }

        override fun toString(): String {
            return "HomePageBlockItem(itemTitle='$itemTitle', itemIconId=$itemIconId, itemType=$itemType, itemTopHightlight='$itemTopHighlight', itemTop='$itemTop', itemBottom='$itemBottom')"
        }
    }
}

val gradient = Brush.verticalGradient(
    colors = listOf(
        BlackAlpha80,
        Color.Transparent,
    )
)

@Composable
fun HomePageBlock1x1(blockData: HomePageBlocks.HomePageBlockItem, modifier: Modifier = Modifier, navController: NavController) {
    val config = LocalConfiguration.current
    var isLandscape = false;

    when (config.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
        }
    }

    OutlinedButton(
        contentPadding = PaddingValues(10.dp),
        onClick = {
            if (blockData.itemOnClickToNavigate !== null) {
                println("Ok I'm Navigating to "+blockData.itemOnClickToNavigate)
                navController.navigate(blockData.itemOnClickToNavigate!!.route)
            } else {
                println("Ok I'm OnClick la")
                blockData.itemOnClickAction;
            }
        },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .background(BlackAlpha20, RoundedCornerShape(8.dp))
            .height(90.dp)
            .width(80.dp),
        border = BorderStroke(2.dp, Color(0x66907C54))
    ) {
        Column {
            Image(
                painter = painterResource(id = blockData.itemIconId),
                contentDescription = blockData.itemTitle,
                Modifier
                    .size(32.dp)
                    .align(Alignment.CenterHorizontally),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = blockData.itemTitle,
                Modifier
                    .align(Alignment.CenterHorizontally),
                color = TextColorNormal,
                style = FontSizeNormalSmall,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun HomePageBlock2x1(blockData: HomePageBlocks.HomePageBlockItem, modifier: Modifier = Modifier, navController: NavController) {
    val navController = rememberNavController();
    val config = LocalConfiguration.current
    var isLandscape = false;

    when (config.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
        }
    }

    OutlinedButton(
        contentPadding = PaddingValues(10.dp),
        onClick = {
            if (blockData.itemOnClickToNavigate !== null) {
                //navController.navigate(NavigateController.NavPath.HomePage.name)
            } else {
                blockData.itemOnClickAction;
            }
        },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .background(BlackAlpha20, RoundedCornerShape(8.dp))
            .height(90.dp)
            .width(172.dp),
        border = BorderStroke(2.dp, Color(0x66907C54))
    ) {
        Row {
            //icon & name
            Column {
                Image(
                    painter = painterResource(id = blockData.itemIconId),
                    contentDescription = blockData.itemTitle,
                    Modifier
                        .size(32.dp)
                        .align(Alignment.CenterHorizontally),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = blockData.itemTitle,
                    Modifier
                        .align(Alignment.CenterHorizontally),
                    color = TextColorNormal,
                    style = FontSizeNormalSmall,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(Modifier.width(32.dp))
            Column {
                Row(
                    Modifier.height(32.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = blockData.itemTopHighlight!!,
                        Modifier.height(IntrinsicSize.Max),
                        color = TextColorNormal,
                        style = FontSizeNormalLarge,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = blockData.itemTop!!,
                        Modifier.height(IntrinsicSize.Max),
                        color = TextColorNormal,
                        style = FontSizeNormal16,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = blockData.itemBottom!!,
                    Modifier
                        .align(Alignment.CenterHorizontally),
                    color = TextColorNormal,
                    style = FontSizeNormalSmall,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageBlockPreview() {
    Stargazer3Theme {
        Row(Modifier.background(Color(0xFF000000))) {
            HomePageBlock1x1(
                HomePageBlocks.HomePageBlockItem(
                    itemTitle = "角色aaaaaaaaaaaaaaaa",
                    itemIconId = R.drawable.phorphos_person_fill,
                ),
                navController = rememberNavController()
            )
            HomePageBlock2x1(
                HomePageBlocks.HomePageBlockItem(
                    itemTitle = "開拓力",
                    itemIconId = R.drawable.phorphos_moon_fill,
                    itemType = HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W2H1,
                    itemTopHighlight = "116",
                    itemTop = "/240",
                    itemBottom = "今天18:16"
                ),
                navController = rememberNavController()
            )
        }
    }
}