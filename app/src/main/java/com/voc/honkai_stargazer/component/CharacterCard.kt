/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.component

import android.graphics.Bitmap
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
val CHAR_CARD_HEIGHT = 102.dp
val CHAR_CARD_WIDTH = 80.dp
val CHAR_CARD_TITLE_HEIGHT = 20.dp

@Composable
fun CharacterCard(
    character: Character,
    level: Int? = -1,
    ascensionPhase: Int? = -1, //Rank 突破等級
    displayName: String? = "?",
    isMultiDisplay: Boolean? = false, //展示推薦隊伍
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .defaultMinSize(CHAR_CARD_WIDTH, CHAR_CARD_HEIGHT)
            .background(
                Brush.verticalGradient(
                    colors = getCardBgColorByRare(character.rarity)
                )
            )
            .clickable(
                onClick = { /* Ignoring onClick */ },
                indication = rememberRipple(),
                interactionSource = interactionSource
            )
    ) {
        //val path = LocalContext.current.assets.open("images/character_icon/${Character.getCharacterImageNameByRegistName(character.registName!!)}.webp")
        //val painter = rememberAsyncImagePainter(model = path)
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                bitmap = Character.getCharacterImageFromJSON(
                    LocalContext.current,
                    UtilTools.ImageFolderType.CHAR_ICON,
                    character.registName!!
                ).asImageBitmap(),
                contentDescription = "Character Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Row(
                Modifier
                    .height(CHAR_CARD_TITLE_HEIGHT)
                    .fillMaxWidth()
                    .background(Color(0xFF222222)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = displayName!!,
                    textAlign = TextAlign.Center,
                    color = TextColorNormalDim,
                    fontSize = 12.sp,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
        }
        Column (modifier = Modifier.padding(2.dp)){
            Image(
                painter = painterResource(id = character.combatType.iconColor),
                contentDescription = "Character Icon",
                modifier = Modifier
                    .requiredWidth(20.dp)
                    .requiredHeight(20.dp)
                    .background(Color(0x66000000), CircleShape)
                    .padding(2.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Image(
                painter = painterResource(id = character.path.iconWhite),
                contentDescription = "Character Icon",
                modifier = Modifier
                    .requiredWidth(20.dp)
                    .requiredHeight(20.dp)
                    .background(Color(0x66000000), CircleShape)
                    .padding(2.dp)
            )
        }
    }
}

@Preview
@Composable
fun CharacterCardPreview() {
    val context = LocalContext.current
    Box {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(80.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(count = 4) {
                CharacterCard(
                    character = Character(
                        officialId = 1006,
                        fileName = "silverwolf",
                        registName = "Silver Wolf",
                        rarity = 5,
                        combatType = CombatType.valueOf("Quantum"),
                        path = Path.Nihility,
                        gender = Gender.Female,
                    ),
                    displayName = "銀狼",
                )
            }
        }
    }
}

