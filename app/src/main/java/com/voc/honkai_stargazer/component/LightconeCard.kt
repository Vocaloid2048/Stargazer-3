/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.component

import android.graphics.Bitmap
import android.graphics.BlurMaskFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.screen.ui.theme.TextColorNormal
import com.voc.honkai_stargazer.screen.ui.theme.TextColorNormalDim
import com.voc.honkai_stargazer.types.Character
import com.voc.honkai_stargazer.types.CombatType
import com.voc.honkai_stargazer.types.Constants.Companion.getCardBgColorByRare
import com.voc.honkai_stargazer.types.Gender
import com.voc.honkai_stargazer.types.Lightcone
import com.voc.honkai_stargazer.types.Path
import com.voc.honkai_stargazer.util.UtilTools
import java.net.URLEncoder

//Start to End, Top to Bottom
val LC_CARD_HEIGHT = 120.dp
val LC_CARD_WIDTH = 80.dp
val LC_CARD_TITLE_HEIGHT = 20.dp

@Composable
fun LightconeCard(
    lightcone: Lightcone,
    level: Int? = -1,
    ascensionPhase: Int? = -1, //Rank 突破等級
    displayName: String? = "?",
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .defaultMinSize(LC_CARD_WIDTH, LC_CARD_HEIGHT)
            .clickable(
                onClick = { /* Ignoring onClick */ },
                indication = rememberRipple(),
                interactionSource = interactionSource
            )
    ) {
        Column {
            Box(
                modifier = Modifier
                    .defaultMinSize(LC_CARD_WIDTH, LC_CARD_WIDTH)
                    .clip(
                        RoundedCornerShape(
                            topEnd = 15.dp,
                            topStart = 4.dp,
                            bottomEnd = 4.dp,
                            bottomStart = 4.dp
                        )
                    )
            ) {
                Image(
                    bitmap = Lightcone.getLightconeImageFromJSON(
                        LocalContext.current,
                        UtilTools.ImageFolderType.LC_ICON,
                        lightcone.registName!!
                    ).asImageBitmap(),
                    contentDescription = "Lightcone Icon",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .background(
                            Brush.verticalGradient(
                                colors = getCardBgColorByRare(lightcone.rarity)
                            )
                        ),
                    contentScale = ContentScale.Crop

                )
            }
            Row(
                Modifier
                    .height(LC_CARD_TITLE_HEIGHT)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = displayName!!,
                    textAlign = TextAlign.Center,
                    color = TextColorNormalDim,
                    fontSize = 12.sp,
                    maxLines = 2
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
        }
        Column(modifier = Modifier.padding(2.dp)) {
            Image(
                painter = painterResource(id = lightcone.path.iconWhite),
                contentDescription = "Lightcone Icon",
                modifier = Modifier
                    .requiredWidth(20.dp)
                    .requiredHeight(20.dp)
                    .background(Color(0x66000000), CircleShape)
                    .padding(2.dp)
            )
        }
    }
}

@Preview(backgroundColor = 0xFF156434, showBackground = true)
@Composable
fun LightconeCardPreview() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(count = 4) {
            LightconeCard(
                lightcone = Lightcone(
                    officialId = 21018,
                    registName = "Dance! Dance! Dance!",
                    fileName = "21018",
                    rarity = 4,
                    path = Path.Harmony,
                ),
                displayName = "舞！舞！舞！",
            )
        }
    }
}

