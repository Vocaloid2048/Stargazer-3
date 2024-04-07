/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.types

import com.voc.honkai_stargazer.R

/**
 * 屬性 CombatType
 */
enum class CombatType (var chName : String, iconWhite : Int, iconColor : Int, localeStringId : Int = R.string.app_name){
    Imaginary("虛數", R.drawable.ic_imaginary, R.drawable.element_imaginary),
    Quantum("毀滅", R.drawable.ic_quatumn, R.drawable.element_quantum),
    Lightning("智識", R.drawable.ic_lightning, R.drawable.element_lightning),
    Fire("同諧", R.drawable.ic_fire, R.drawable.element_fire),
    Ice("巡獵", R.drawable.ic_ice, R.drawable.element_ice),
    Wind("虛無", R.drawable.icon_wind, R.drawable.element_wind),
    Physical("存謢", R.drawable.ic_physical, R.drawable.element_physical),
}