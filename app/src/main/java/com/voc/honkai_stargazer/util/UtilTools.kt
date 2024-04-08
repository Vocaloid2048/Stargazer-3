/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.voc.honkai_stargazer.R
import java.io.BufferedReader
import java.io.IOException

class UtilTools {

    //App語言 Language for App (R.string)
    enum class AppLanguage(var localeName: String, var folderName: String){
        VOCCHINESE("Vocchinese","yue"),
        EN("English","en"),
        ZH_CN("简体中文","zh_cn"),
        ZH_HK("繁體中文","zh_hk"),
        JP("日本語","jp"),
        FR("Français","fr"),
        RU("Русский","ru"),
        DE("Deutsch","de"),
        PT("Português","pt-PT"),
        VI("tiếng Việt","vi"),
        ES("Español","es-ES"),
        KR("한국어","kr"),
        TH("ภาษาไทย","th"),
        JYU_YAM("ㄓㄨˋ ㄧㄣ","zh"),
        UK("Українська","uk");
    }

    //文本語言 Language for Text (assets/data)
    enum class TextLanguage(var localeName: String, var folderName: String){
        EN("English","en"),
        ZH_CN("简体中文","zh_cn"),
        ZH_HK("繁體中文","zh_hk"),
        JP("日本語","jp"),
        FR("Français","fr"),
        RU("Русский","ru"),
        DE("Deutsch","de"),
        PT("Português","pt-PT"),
        VI("tiếng Việt","vi"),
        ES("Español","es-ES"),
        KR("한국어","kr"),
        TH("ภาษาไทย","th"),
    }

    enum class ImageFolderType(var folderPath : String, var suffix : String){
        CHAR_EIDOLON("character_eidolon/","_eidolon_${1}.webp"),
        CHAR_EIDOLON_BORDER("character_eidolon_border/",".svg"),
        CHAR_FADE("character_fade/","_fade.webp"),
        CHAR_FULL("character_full/","_full.webp"),
        CHAR_ICON("character_icon/","_icon.webp"),
        CHAR_SKILL("character_skill/","_skill.webp"),
        CHAR_SKILL_TREE("character_skill_tree/",".webp"),
        CHAR_SOUL("character_soul/","_soul_${1}.webp"),
        CHAR_SPLASH("character_splash/","_splash.webp"),

        LC_ARTWORK("lightcone_artwork/","_artwork.webp"),
        LC_ICON("lightcone_icon/",".webp"),
        MAOGOU("maogou/",".webp"),
        MATERIAL_ICON("material_icon/",".webp"),
        MONSTER_ICON("monster_icon/",".webp"),
        ORMANENT_ICON("ornament_icon/","_${1}.webp"),
        ORMANENT_PC_ICON("ornament_pcicon/",".webp"),
        RELIC_ICON("relic_icon/","_${1}.webp"),
        RELIC_PC_ICON("relic_pcicon/",".webp"),
    }

    fun getAssetsJsonByContext(context: Context, fileName: String) : String {
        return context
            .assets
            .open(fileName)
            .bufferedReader()
            .use(BufferedReader::readText)
    }
    fun getAssetsWebpByContext(context: Context, fileName: String) : Bitmap {
        try {
            val openedFile = context.assets.open(fileName);
            return BitmapFactory.decodeStream(openedFile)
        }catch (ex : IOException){
            return BitmapFactory.decodeResource(context.resources,R.drawable.pom_pom)
        }
    }
}