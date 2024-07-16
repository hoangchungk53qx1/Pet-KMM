package com.vn.chungha.pet_kmm.android.presentation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vn.chungha.pet_kmm.android.navigation.PetNavigationDestination

data object PetHomeDestination : PetNavigationDestination {
  override val route = "pet_home_route"
  override val destination = "pet_home_destination"
}

fun NavGraphBuilder.petHomeGraph() = composable(
  route = PetHomeDestination.route,
) {
  PetHomeRoute()
}
