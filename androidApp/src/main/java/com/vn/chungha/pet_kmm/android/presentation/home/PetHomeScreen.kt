package com.vn.chungha.pet_kmm.android.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PetHomeRoute() {
  PetHomeScreen(
    modifier = Modifier,
  )
}

@Composable
fun PetHomeScreen(modifier: Modifier) {
  Box(modifier = modifier) {
    Text(text = "Pet Home Screen")
  }
}
