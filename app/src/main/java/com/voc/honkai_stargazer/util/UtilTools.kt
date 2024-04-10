/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BlurMaskFilter
import android.widget.Toast
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.voc.honkai_stargazer.R
import java.io.BufferedReader
import java.io.IOException

class UtilTools {

    //App語言 Language for App (R.string)
    enum class AppLanguage(var localeName: String, var folderName: String) {
        VOCCHINESE("Vocchinese", "yue"),
        EN("English", "en"),
        ZH_CN("简体中文", "zh_cn"),
        ZH_HK("繁體中文", "zh_hk"),
        JP("日本語", "jp"),
        FR("Français", "fr"),
        RU("Русский", "ru"),
        DE("Deutsch", "de"),
        PT("Português", "pt-PT"),
        VI("tiếng Việt", "vi"),
        ES("Español", "es-ES"),
        KR("한국어", "kr"),
        TH("ภาษาไทย", "th"),
        JYU_YAM("ㄓㄨˋ ㄧㄣ", "zh"),
        UK("Українська", "uk");
    }

    //文本語言 Language for Text (assets/data)
    enum class TextLanguage(var localeName: String, var folderName: String) {
        EN("English", "en"),
        ZH_CN("简体中文", "zh_cn"),
        ZH_HK("繁體中文", "zh_hk"),
        JP("日本語", "jp"),
        FR("Français", "fr"),
        RU("Русский", "ru"),
        DE("Deutsch", "de"),
        PT("Português", "pt-PT"),
        VI("tiếng Việt", "vi"),
        ES("Español", "es-ES"),
        KR("한국어", "kr"),
        TH("ภาษาไทย", "th"),
    }

    enum class ImageFolderType(var folderPath: String, var suffix: String) {
        AVATAR_ICON("avatar_icon/", ".webp"),
        BGS("bgs/", ".webp"),

        CHAR_EIDOLON("character_eidolon/", "_eidolon_${1}.webp"),
        CHAR_EIDOLON_BORDER("character_eidolon_border/", ".svg"),
        CHAR_FADE("character_fade/", "_fade.webp"),
        CHAR_FULL("character_full/", "_full.webp"),
        CHAR_ICON("character_icon/", "_icon.webp"),
        CHAR_SKILL("character_skill/", "_skill.webp"),
        CHAR_SKILL_TREE("character_skill_tree/", ".webp"),
        CHAR_SOUL("character_soul/", "_soul_${1}.webp"),
        CHAR_SPLASH("character_splash/", "_splash.webp"),

        LC_ARTWORK("lightcone_artwork/", "_artwork.webp"),
        LC_ICON("lightcone_icon/", ".webp"),
        MAOGOU("maogou/", ".webp"),
        MATERIAL_ICON("material_icon/", ".webp"),
        MONSTER_ICON("monster_icon/", ".webp"),
        ORMANENT_ICON("ornament_icon/", "_${1}.webp"),
        ORMANENT_PC_ICON("ornament_pcicon/", ".webp"),
        RELIC_ICON("relic_icon/", "_${1}.webp"),
        RELIC_PC_ICON("relic_pcicon/", ".webp"),
    }

    fun getAssetsJsonByContext(context: Context, fileName: String): String {
        return try {
            context
                .assets
                .open(fileName)
                .bufferedReader()
                .use(BufferedReader::readText)
        } catch (ex : IOException){
            Toast.makeText(context, "File ${fileName} not exist!", Toast.LENGTH_SHORT).show()
            "?"
        }
    }

    fun getAssetsWebpByContext(context: Context, fileName: String): Bitmap {
        return try {
            val openedFile = context.assets.open(fileName)
            BitmapFactory.decodeStream(openedFile)
        } catch (ex: IOException) {
            BitmapFactory.decodeResource(context.resources, R.drawable.pom_pom)
        }
    }

    fun getImageNameByRegistName(registName: String) : String {
        return registName
            .replace("Trailblazer Boy (Physical)","trailblazer_physical_male")
            .replace("Trailblazer Girl (Physical)","trailblazer_physical_female")
            .replace("Trailblazer Boy (Fire)","trailblazer_fire_male")
            .replace("Trailblazer Girl (Fire)","trailblazer_fire_female")
            .replace("Topaz & Numby","topaz")
            .replace("Dan Heng • Imbibitor Lunae","dan_heng_il")
            .replace("Void","Void_")

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
            .replace(" ","_")
            .replace("-","_")
    }
}