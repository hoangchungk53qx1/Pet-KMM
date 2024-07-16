package com.vn.chungha.pet_kmm.android.presentation.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.vn.chungha.pet_kmm.android.designsystem.PetCodeTheme
import com.vn.chungha.pet_kmm.android.navigation.TopLevelDestination
import kotlinx.collections.immutable.ImmutableList

@Composable
fun PetBottomBar(
  destinations: ImmutableList<TopLevelDestination>,
  currentDestination: TopLevelDestination,
  onNavigateToDestination: (TopLevelDestination) -> Unit,
  modifier: Modifier = Modifier,
  color: Color = PetCodeTheme.color.background,
) {
  BottomNavigation(
    modifier = modifier,
    backgroundColor = color,
  ) {
    destinations.forEach { destination ->
      val selected = destination == currentDestination

      val icon = painterResource(id = if (!selected) destination.iconResourceId else destination.iconResourceSelect)
      val text = stringResource(id = destination.textResourceId)

      val tint by animateColorAsState(
        if (selected) {
          PetCodeTheme.color.primary
        } else {
          PetCodeTheme.color.neutral3
        },
        label = text,
      )

      BottomNavigationItem(
        icon = {
          Image(
            painter = icon,
            contentDescription = text,
          )
        },
        label = {
          Text(
            text = text,
            color = tint,
            maxLines = 1,
            style = PetCodeTheme.typo.innerBoldSize12Line16,
          )
        },
        selected = selected,
        onClick = { onNavigateToDestination(destination) },
      )
    }
  }
}