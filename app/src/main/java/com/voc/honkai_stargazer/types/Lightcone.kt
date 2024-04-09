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


class Lightcone(
    var officialId : Int? = 21018,
    var registName : String? = "Dance! Dance! Dance!",
    var fileName : String? = "21018",
    var rarity : Int = 4,
    var path : Path = Path.Harmony,
    var releaseVersion : String = "1.0.0",
){
    companion object {
        fun getLightconeListFromJSON(context: Context) : String {
            return UtilTools().getAssetsJsonByContext(context, "data/lightcone_data/lightcone_list.json")
        }

        fun getLightconeDataFromJSON(context: Context, lightconeFileName : String, textLanguage: UtilTools.TextLanguage) : String {
            return UtilTools().getAssetsJsonByContext(context,"data/lightcone_data/${textLanguage.folderName}/${lightconeFileName}.json")
        }

        fun getLightconeImageFromJSON(context: Context, imageFolderType: UtilTools.ImageFolderType, lightconeName : String) : Bitmap {
            return UtilTools().getAssetsWebpByContext(context,
                "images/"
                        +imageFolderType.folderPath
                        +getLightconeImageNameByRegistName(lightconeName)
                        +imageFolderType.suffix
            )
        }

        fun getLightconeImageNameByRegistName(registName: String) : String {
            return registName
                .lowercase()
                .replace("(","")
                .replace(")","")
                .replace("!","")
                .replace("?","")
                .replace(":","")
                .replace(",","")
                .replace("\"","")
                .replace("\'","")
                .replace(".","")
                .replace("void","void_")
                .replace(" ","_")
        }
    }
}