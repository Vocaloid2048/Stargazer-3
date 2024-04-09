/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.screen

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.component.CHAR_CARD_HEIGHT
import com.voc.honkai_stargazer.component.CHAR_CARD_WIDTH
import com.voc.honkai_stargazer.component.CharacterCard
import com.voc.honkai_stargazer.component.HeaderData
import com.voc.honkai_stargazer.component.LC_CARD_HEIGHT
import com.voc.honkai_stargazer.component.LISTHEADER_HEIGHT
import com.voc.honkai_stargazer.component.LightconeCard
import com.voc.honkai_stargazer.component.ListHeader
import com.voc.honkai_stargazer.component.defaultHeaderData
import com.voc.honkai_stargazer.types.Character
import com.voc.honkai_stargazer.types.CombatType
import com.voc.honkai_stargazer.types.Lightcone
import com.voc.honkai_stargazer.types.Path
import com.voc.honkai_stargazer.util.RootContent
import com.voc.honkai_stargazer.util.Screen
import com.voc.honkai_stargazer.util.UtilTools
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun LightconeListPage(modifier: Modifier = Modifier, navController: NavController, headerData: HeaderData = defaultHeaderData) {
    //val hazeState = remember { HazeState() }
    val lcListJSON: JSONArray = JSONArray(Lightcone.getLightconeListFromJSON(LocalContext.current))
    val lcNameList: ArrayList<String> = arrayListOf()
    for ( x in (0..<lcListJSON.length())){
        lcNameList.add(JSONObject(Lightcone.getLightconeDataFromJSON(
            LocalContext.current,
            lcListJSON.getJSONObject(x).getString("fileName"),
            UtilTools.TextLanguage.ZH_HK
        )).getString("name"))
    }

    Box {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            //.haze(state = hazeState),
            columns = GridCells.Adaptive(CHAR_CARD_WIDTH),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            state = rememberLazyGridState(),
        ) {
            item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                Spacer(
                    modifier = Modifier
                        .statusBarsPadding()
                        .height(LISTHEADER_HEIGHT)
                )
            }
            items(count = lcListJSON.length()) { index ->
                val lcListItem = lcListJSON.getJSONObject(index)
                LightconeCard(
                    lightcone = Lightcone(
                        registName = lcListItem.getString("name"),
                        fileName = lcListItem.getString("fileName"),
                        rarity = lcListItem.getInt("rare"),
                        path = Path.valueOf(lcListItem.getString("path")),
                    ),
                    displayName = lcNameList[index]
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .height(0.dp)
                )
            }
        }
        ListHeader(navController = navController, headerData = headerData)//hazeState = hazeState)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightconeListPagePreview() {
    RootContent(
        screen = Screen.LightconeListPage,
        navController = rememberNavController(),
        page = {LightconeListPage(navController = rememberNavController()) })
}