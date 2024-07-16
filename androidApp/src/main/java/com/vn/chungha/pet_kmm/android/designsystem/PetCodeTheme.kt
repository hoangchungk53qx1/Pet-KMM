package com.vn.chungha.pet_kmm.android.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.luminance
import com.vn.chungha.pet_kmm.android.designsystem.internal.LocalThemeColors
import com.vn.chungha.pet_kmm.android.designsystem.internal.ThemeColors
import com.vn.chungha.pet_kmm.android.designsystem.internal.ThemeDimens
import com.vn.chungha.pet_kmm.android.designsystem.internal.ThemeShapes
import com.vn.chungha.pet_kmm.android.designsystem.internal.ThemeTypo

object PetCodeTheme {
  val color: ThemeColors
    @Composable
    @ReadOnlyComposable
    get() = LocalThemeColors.current

  val typo: ThemeTypo
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypo()

  val shape: ThemeShapes
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapes()

  val dimen: ThemeDimens
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimens()

  val isDark: Boolean
    @Composable
    @ReadOnlyComposable
    get() = color.background.luminance() < 0.5
}
