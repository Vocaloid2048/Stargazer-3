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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.component.BackIcon
import com.voc.honkai_stargazer.component.CHAR_CARD_HEIGHT
import com.voc.honkai_stargazer.component.CHAR_CARD_WIDTH
import com.voc.honkai_stargazer.component.CharacterCard
import com.voc.honkai_stargazer.component.HeaderData
import com.voc.honkai_stargazer.component.LC_CARD_HEIGHT
import com.voc.honkai_stargazer.component.LISTHEADER_HEIGHT
import com.voc.honkai_stargazer.component.LightconeCard
import com.voc.honkai_stargazer.component.ListHeader
import com.voc.honkai_stargazer.component.RelicCard
import com.voc.honkai_stargazer.component.defaultHeaderData
import com.voc.honkai_stargazer.types.Character
import com.voc.honkai_stargazer.types.CombatType
import com.voc.honkai_stargazer.types.Lightcone
import com.voc.honkai_stargazer.types.Path
import com.voc.honkai_stargazer.types.Relic
import com.voc.honkai_stargazer.util.RootContent
import com.voc.honkai_stargazer.util.Screen
import com.voc.honkai_stargazer.util.UtilTools
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun RelicListPage(modifier: Modifier = Modifier, navController: NavController, headerData: HeaderData = defaultHeaderData) {
    val hazeState = remember { HazeState() }
    val relicListJSON: JSONArray = JSONArray(Relic.getRelicListFromJSON(LocalContext.current))
    val relicNameList: ArrayList<String> = arrayListOf()
    for ( x in (0..<relicListJSON.length())){
        relicNameList.add(JSONObject(Relic.getRelicDataFromJSON(
            LocalContext.current,
            relicListJSON.getJSONObject(x).getString("fileName"),
            UtilTools.TextLanguage.ZH_HK
        )).getString("name"))
    }

    Box {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .haze(state = hazeState),
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
            items(count = relicListJSON.length()) { index ->
                val relicListItem = relicListJSON.getJSONObject(index)
                RelicCard(
                    relic = Relic(
                        registName = relicListItem.getString("name"),
                        fileName = relicListItem.getString("fileName"),
                        officialId = relicListItem.getString("fileName").toInt(),
                    ),
                    displayName = relicNameList[index]
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
        ListHeader(navController = navController, headerData = headerData, hazeState = hazeState, backIconId = BackIcon.CANCEL)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RelicListPagePreview() {
    RootContent(
        screen = Screen.LightconeListPage,
        navController = rememberNavController(),
        page = {RelicListPage(navController = rememberNavController()) })
}