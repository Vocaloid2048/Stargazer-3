/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.voc.honkai_stargazer.component.CharacterCard
import com.voc.honkai_stargazer.component.ListHeader
import com.voc.honkai_stargazer.types.Character
import com.voc.honkai_stargazer.types.CombatType
import com.voc.honkai_stargazer.types.Path
import com.voc.honkai_stargazer.util.RootContent
import com.voc.honkai_stargazer.util.UtilTools
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun CharacterListPage(modifier: Modifier = Modifier, navController: NavController) {
    //val hazeState = remember { HazeState() }
    val charList: JSONArray = JSONArray(Character.getCharacterListFromJSON(LocalContext.current))
    Box {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .statusBarsPadding(),
            //.haze(state = hazeState),
            columns = GridCells.Adaptive(80.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(count = charList.length()) { index ->
                var charDataInList: JSONObject = charList.getJSONObject(index)
                var character = Character(
                    registName = charDataInList.getString("name"),
                    fileName = charDataInList.getString("fileName"),
                    combatType = CombatType.valueOf(charDataInList.getString("element")),
                    rarity = charDataInList.getInt("rare"),
                    path = Path.valueOf(charDataInList.getString("path")),
                )
                CharacterCard(
                    character = character,
                    characterIcon = Character.getCharacterImageFromJSON(
                        context = LocalContext.current,
                        UtilTools.ImageFolderType.CHAR_ICON,
                        character.registName!!
                    ),

                )
            }

        }
        ListHeader(navController = navController)//hazeState = hazeState)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CharacterListPagePreview() {
    RootContent(
        navController = rememberNavController(),
        page = { CharacterListPage(navController = rememberNavController()) })
}