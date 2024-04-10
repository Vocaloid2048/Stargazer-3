/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.types

import androidx.compose.ui.graphics.Color
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.component.HomePageBlocks
import com.voc.honkai_stargazer.util.Screen

class Constants {
    companion object {

        //From top to bottom
        val CARD_BG_COLOR_RARE_1 = listOf(Color(0xFF191621), Color(0xFF8F8F95))
        val CARD_BG_COLOR_RARE_2 = listOf(Color(0xFF374860), Color(0xFF3F797C))
        val CARD_BG_COLOR_RARE_3 = listOf(Color(0xFF393A5C), Color(0xFF497AB8))
        val CARD_BG_COLOR_RARE_4 = listOf(Color(0xFF404165), Color(0xFF9763CE))
        val CARD_BG_COLOR_RARE_5 = listOf(Color(0xFF905A52), Color(0xFFC8A471))
        val CARD_BG_COLOR_RARE_UNKNOWN = listOf(Color(0xFF905273), Color(0xFF71B8C8))

        fun getCardBgColorByRare(rare: Int): List<Color> {
            when (rare) {
                1 -> return CARD_BG_COLOR_RARE_1
                2 -> return CARD_BG_COLOR_RARE_2
                3 -> return CARD_BG_COLOR_RARE_3
                4 -> return CARD_BG_COLOR_RARE_4
                5 -> return CARD_BG_COLOR_RARE_5
            }
            return CARD_BG_COLOR_RARE_UNKNOWN
        }

        var HOME_PAGE_ITEMS = arrayListOf<HomePageBlocks.HomePageBlockItem>(
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.Character,
                itemIconId = R.drawable.phorphos_person_fill,
                itemOnClickToNavigate = Screen.CharacterListPage,
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.Lightcone,
                itemIconId = R.drawable.phorphos_sword_fill,
                itemOnClickToNavigate = Screen.LightconeListPage,
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.Relic,
                itemIconId = R.drawable.phorphos_baseball_cap_fill,
                itemOnClickToNavigate = Screen.RelicListPage,
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.UIDSearch,
                itemIconId = R.drawable.phorphos_alien_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.Stamina,
                itemIconId = R.drawable.phorphos_moon_fill,
                itemType = HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W2H1,
                itemTopHighlight = "116",
                itemTop = "/240",
                itemBottom = "今天18:16"
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "100/500",
                itemIconId = R.drawable.phorphos_calendar_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "2.4K/14K",
                itemIconId = R.drawable.phorphos_planet_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.Expedition,
                itemIconId = R.drawable.phorphos_users_fill,
                itemType = HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W2H1,
                itemTopHighlight = "4",
                itemTop = "/4",
                itemBottom = "已完成"
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.MemoryOfChaos,
                itemIconId = R.drawable.phorphos_medal_military_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.PureFiction,
                itemIconId = R.drawable.phorphos_atom_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.Event,
                itemIconId = R.drawable.phorphos_film_slate_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.ScoreLevelLeaderboard,
                itemIconId = R.drawable.phorphos_trophy_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.MemoryOfChaosLeaderboard,
                itemIconId = R.drawable.phorphos_chart_bar_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.PureFictionLeaderboard,
                itemIconId = R.drawable.phorphos_chart_bar_horizontal_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.Map,
                itemIconId = R.drawable.phorphos_map_trifold_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.LotterySimulator,
                itemIconId = R.drawable.phorphos_star_of_david_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitleRId = R.string.WrapAnalysis,
                itemIconId = R.drawable.phorphos_shooting_star_fill
            ),
        )
    }
}