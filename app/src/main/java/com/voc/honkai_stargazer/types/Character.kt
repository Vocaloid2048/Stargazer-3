/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.types

import android.content.Context
import com.voc.honkai_stargazer.util.UtilTools
import java.io.BufferedReader

enum class Gender{
    Male, Female
}
class Character(
    var officialId : Int? = 1006,
    var name : String? = "Silver Wolf",
    var fileName : String? = "silverwolf",
    var displayName : String? = "?",
    var rarity : Int,
    var level : Int,
    var ascensionPhase : Int, //Rank 突破等級
    var path : Path,
    var combatType: CombatType,
    var characterIcon : Int,
    var gender : Gender
){

    companion object {
        fun getCharacterListFromJSON(context: Context) : String {
            return UtilTools().getAssetsByContext(context, "data/character_data/character_list.json")
        }
    }
}