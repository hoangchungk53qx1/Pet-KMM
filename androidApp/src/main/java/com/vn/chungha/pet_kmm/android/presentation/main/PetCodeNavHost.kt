package com.vn.chungha.pet_kmm.android.presentation.main

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.vn.chungha.pet_kmm.android.navigation.PetNavigationDestination
import com.vn.chungha.pet_kmm.android.presentation.favorite.favoriteGraph
import com.vn.chungha.pet_kmm.android.presentation.home.petHomeGraph
import com.vn.chungha.pet_kmm.android.presentation.settings.settingsGraph

@Composable
fun PetCodeNavHost(
  navController: NavHostController,
  startDestination: PetNavigationDestination,
  onNavigateToDestination: (PetNavigationDestination, String) -> Unit,
  onNavigateToDestinationPopUpTo: (PetNavigationDestination, String) -> Unit,
  onBackClick: () -> Unit,
  showBottomBar: (Boolean) -> Unit,
  modifier: Modifier = Modifier,
) {
  NavHost(
    modifier = modifier,
    navController = navController,
    startDestination = startDestination.route,
    enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
    exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
    popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) },
    popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) },
  ) {
    petHomeGraph()
    favoriteGraph()
    settingsGraph()
  }
}
