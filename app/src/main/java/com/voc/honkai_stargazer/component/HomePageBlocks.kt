package com.voc.honkai_stargazer.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.screen.gradient
import com.voc.honkai_stargazer.ui.theme.Black
import com.voc.honkai_stargazer.ui.theme.BlackAlpha20
import com.voc.honkai_stargazer.ui.theme.BlackAlpha80
import com.voc.honkai_stargazer.ui.theme.FontSizeNormal
import com.voc.honkai_stargazer.ui.theme.FontSizeNormal16
import com.voc.honkai_stargazer.ui.theme.FontSizeNormalLarge
import com.voc.honkai_stargazer.ui.theme.FontSizeNormalSmall
import com.voc.honkai_stargazer.ui.theme.Stargazer3Theme
import com.voc.honkai_stargazer.ui.theme.TextColorLevel
import com.voc.honkai_stargazer.ui.theme.TextColorNormal

class HomePageBlocks {
    class HomePageBlockItem(
        var itemTitle: String = "",
        var itemIconId: Int = R.drawable.phorphos_cake_fill,
        var itemType: HomePageBlockItemType = HomePageBlockItemType.W1H1,
        var itemTopHighlight: String = "",
        var itemTop: String = "",
        var itemBottom: String = "",
    ) {
        enum class HomePageBlockItemType {
            W1H1, W2H1
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
public fun HomePageBlock1x1(blockData: HomePageBlocks.HomePageBlockItem, modifier: Modifier = Modifier) {
    OutlinedButton(
        contentPadding = PaddingValues(10.dp),
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .background(BlackAlpha20)
            .height(90.dp)
            .width(80.dp),
        border = BorderStroke(1.dp, Color(0x66907C54))
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
public fun HomePageBlock2x1(blockData: HomePageBlocks.HomePageBlockItem, modifier: Modifier = Modifier) {
    OutlinedButton(
        contentPadding = PaddingValues(10.dp),
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .background(BlackAlpha20)
            .height(90.dp)
            .width(172.dp),
        border = BorderStroke(1.dp, Color(0x66907C54))
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
                        text = blockData.itemTopHighlight,
                        Modifier.height(IntrinsicSize.Max),
                        color = TextColorNormal,
                        style = FontSizeNormalLarge,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = blockData.itemTop,
                        Modifier.height(IntrinsicSize.Max),
                        color = TextColorNormal,
                        style = FontSizeNormal16,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = blockData.itemBottom,
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
                    itemIconId = R.drawable.phorphos_person_fill
                )
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
            )
        }
    }
}