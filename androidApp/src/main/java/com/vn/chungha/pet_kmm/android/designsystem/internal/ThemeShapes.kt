package com.vn.chungha.pet_kmm.android.designsystem.internal

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Immutable
@Stable
class ThemeShapes {
  val rect = RectangleShape
  val circle = CircleShape
  val smallCorner = RoundedCornerShape(4.dp)
  val roundedButton = RoundedCornerShape(24.dp)
  val roundedDefault = RoundedCornerShape(12.dp)
  val roundedSmall = RoundedCornerShape(8.dp)
  val roundedLarge = RoundedCornerShape(16.dp)
  val roundedChip = RoundedCornerShape(20.dp)
  val roundedSuperLarge = RoundedCornerShape(32.dp)
  val dialog = RoundedCornerShape(24.dp)
  val tab = RoundedCornerShape(60.dp)
}
