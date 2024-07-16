package com.vn.chungha.pet_kmm.android.presentation.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun SettingRoute() {
  SettingScreen(
    modifier = Modifier,
  )
}

@Composable
fun SettingScreen(modifier: Modifier) {
  Box(modifier = modifier) {
    Text(text = "SettingScreen Screen")
  }
}
