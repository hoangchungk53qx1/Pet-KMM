package com.vn.chungha.pet_kmm.android.presentation.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun FavoriteRoute() {
  FavoriteScreen(
    modifier = Modifier,
  )
}

@Composable
fun FavoriteScreen(modifier: Modifier) {
  Box(modifier = modifier) {
    Text(text = "Favorite Screen")
  }
}
