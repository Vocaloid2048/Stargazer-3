/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package com.voc.honkai_stargazer.util

import android.content.Context
import java.io.BufferedReader

class UtilTools {
    fun getAssetsByContext(context: Context, fileName: String) : String {
        return context
            .assets
            .open(fileName)
            .bufferedReader()
            .use(BufferedReader::readText)
    }
}