package com.vn.chungha.pet_kmm.android.presentation.favorite

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vn.chungha.pet_kmm.android.navigation.PetNavigationDestination

data object FavoriteDestination : PetNavigationDestination {
    override val route = "favorite_route"
    override val destination = "favorite_destination"
}

fun NavGraphBuilder.favoriteGraph() = composable(
    route = FavoriteDestination.route
) {
    FavoriteRoute()
}