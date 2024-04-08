/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.types

import com.voc.honkai_stargazer.R

enum class Path (var chName : String,var iconWhite : Int, var iconAbyss : Int, localeStringId : Int = R.string.app_name){
    Abundance("豐饒", R.drawable.path_the_abundance, R.drawable.path_the_abundance_abyss),
    Destruction("毀滅", R.drawable.path_the_destruction, R.drawable.path_the_destruction_abyss),
    Erudition("智識", R.drawable.path_the_erudition, R.drawable.path_the_erudition_abyss),
    Harmony("同諧", R.drawable.path_the_harmony, R.drawable.path_the_harmony_abyss),
    Hunt("巡獵", R.drawable.path_the_hunt, R.drawable.path_the_hunt_abyss),
    Nihility("虛無", R.drawable.path_the_nihility, R.drawable.path_the_nihility_abyss),
    Preservation("存謢", R.drawable.path_the_preservation, R.drawable.path_the_preservation_abyss);

    companion object {
        fun getPathByName(registName : String) = Path.valueOf(registName);
    }

}