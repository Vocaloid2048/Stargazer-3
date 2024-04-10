/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.types

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.ui.platform.LocalContext
import com.voc.honkai_stargazer.util.UtilTools
import java.io.BufferedReader

enum class Gender{
    Male, Female
}


class Character(
    var officialId : Int? = 1006,
    var registName : String? = "Silver Wolf",
    var fileName : String? = "silverwolf",
    var rarity : Int = 5,
    var path : Path = Path.Harmony,
    var combatType: CombatType = CombatType.Quantum,
    var gender : Gender = Gender.Female,
    var releaseVersion : String = "1.0.0",
){
    companion object {
        fun getCharacterListFromJSON(context: Context) : String {
            return UtilTools().getAssetsJsonByContext(context, "data/character_data/character_list.json")
        }

        fun getCharacterDataFromJSON(context: Context, characterFileName : String, textLanguage: UtilTools.TextLanguage) : String {
            return UtilTools().getAssetsJsonByContext(context,"data/character_data/${textLanguage.folderName}/${characterFileName}.json")
        }

        fun getCharacterImageFromJSON(context: Context, imageFolderType: UtilTools.ImageFolderType, characterName : String) : Bitmap {
            return UtilTools().getAssetsWebpByContext(context,
                "images/"
                        +imageFolderType.folderPath
                        +UtilTools().getImageNameByRegistName(characterName)
                        +imageFolderType.suffix
            )
        }
    }
}