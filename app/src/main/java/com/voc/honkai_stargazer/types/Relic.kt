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


class Relic(
    var officialId : Int? = 21018,
    var registName : String? = "Dance! Dance! Dance!",
    var fileName : String? = "21018",
    var rarity : Int? = 5, //其實沒甚麼用 因爲肯定是五星的
    var releaseVersion : String = "1.0.0",
){
    companion object {
        fun getRelicListFromJSON(context: Context) : String {
            return UtilTools().getAssetsJsonByContext(context, "data/relic_data/relic_list.json")
        }

        fun getRelicDataFromJSON(context: Context, relicFileName : String, textLanguage: UtilTools.TextLanguage) : String {
            return UtilTools().getAssetsJsonByContext(context,"data/relic_data/${textLanguage.folderName}/${relicFileName}.json")
        }

        fun getRelicImageFromJSON(context: Context, imageFolderType: UtilTools.ImageFolderType, imageFileName : String) : Bitmap {
            return UtilTools().getAssetsWebpByContext(context,
                "images/"
                        +imageFolderType.folderPath
                        + UtilTools().getImageNameByRegistName(imageFileName)
                        +imageFolderType.suffix
            )
        }
    }
}