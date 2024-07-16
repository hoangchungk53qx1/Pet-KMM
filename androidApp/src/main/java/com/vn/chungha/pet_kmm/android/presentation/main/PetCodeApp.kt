package com.vn.chungha.pet_kmm.android.presentation.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vn.chungha.pet_kmm.android.designsystem.internal.PetAppBaseTheme
import com.vn.chungha.pet_kmm.android.navigation.PetNavigationDestination
import com.vn.chungha.pet_kmm.android.presentation.home.PetHomeDestination

@Composable
fun PetCodeApp(
  modifier: Modifier = Modifier,
  startDestination: PetNavigationDestination = PetHomeDestination,
  appState: PetCodeAppState = rememberPetAppState(),
) {
  PetAppBaseTheme {
    Scaffold(
      modifier = modifier,
      bottomBar = {
        AnimatedVisibility(
          visible = appState.shouldShowBottomBar,
        ) {
          PetBottomBar(
            destinations = appState.topLevelDestinations,
            currentDestination = appState.currentTopLevelDestination,
            onNavigateToDestination = {
              appState.navigate(it)
            },
          )
        }
      },
      snackbarHost = {
      },
    ) { innerPadding ->
      Box(
        modifier = Modifier
          .padding(paddingValues = innerPadding)
          .consumeWindowInsets(paddingValues = innerPadding),
      ) {
        PetCodeNavHost(
          navController = appState.navController,
          startDestination = startDestination,
          onNavigateToDestination = appState::navigate,
          onNavigateToDestinationPopUpTo = appState::navigateWithPopUpTo,
          onBackClick = {},
          showBottomBar = {},
        )
      }
    }
  }
}
