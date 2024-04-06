package com.voc.honkai_stargazer.constants

import android.view.View
import android.widget.Toast
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.component.HomePageBlocks

class Constants {
    companion object {
        val HOME_PAGE_ITEMS = arrayListOf<HomePageBlocks.HomePageBlockItem>(
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "角色",
                itemIconId = R.drawable.phorphos_person_fill,
                itemOnClick = { System.out.println("WTFFFF") }
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "光錐",
                itemIconId = R.drawable.phorphos_sword_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "遺器",
                itemIconId = R.drawable.phorphos_baseball_cap_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "UID查詢",
                itemIconId = R.drawable.phorphos_alien_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "開拓力",
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
                itemTitle = "派遣",
                itemIconId = R.drawable.phorphos_users_fill,
                itemType = HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W2H1,
                itemTopHighlight = "4",
                itemTop = "/4",
                itemBottom = "已完成"
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "混沌回憶",
                itemIconId = R.drawable.phorphos_medal_military_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "虛構敘事",
                itemIconId = R.drawable.phorphos_atom_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "活動",
                itemIconId = R.drawable.phorphos_film_slate_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "練度排行榜",
                itemIconId = R.drawable.phorphos_trophy_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "混沌排行榜",
                itemIconId = R.drawable.phorphos_chart_bar_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "虛構排行榜",
                itemIconId = R.drawable.phorphos_chart_bar_horizontal_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "地圖",
                itemIconId = R.drawable.phorphos_map_trifold_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "躍遷模擬",
                itemIconId = R.drawable.phorphos_star_of_david_fill
            ),
            HomePageBlocks.HomePageBlockItem(
                itemTitle = "躍遷分析",
                itemIconId = R.drawable.phorphos_shooting_star_fill
            ),
        )
    }
}