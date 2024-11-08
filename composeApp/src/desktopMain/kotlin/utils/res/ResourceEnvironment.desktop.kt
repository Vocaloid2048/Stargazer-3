package utils.res

import org.jetbrains.compose.resources.DensityQualifier
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.LanguageQualifier
import org.jetbrains.compose.resources.RegionQualifier
import org.jetbrains.compose.resources.ThemeQualifier
import org.jetbrains.skiko.SystemTheme
import org.jetbrains.skiko.currentSystemTheme
import java.awt.Toolkit
import java.util.Locale

@OptIn(InternalResourceApi::class)
internal actual fun getSystemEnvironment(): ResourceEnvironment {
    val locale = Locale.getDefault()
    //FIXME: don't use skiko internals
    val isDarkTheme = currentSystemTheme == SystemTheme.DARK
    val dpi = Toolkit.getDefaultToolkit().screenResolution
    return ResourceEnvironment(
        language = LanguageQualifier(locale.language),
        region = RegionQualifier(locale.country),
        theme = ThemeQualifier.selectByValue(isDarkTheme),
        density = DensityQualifier.selectByValue(dpi)
    )
}