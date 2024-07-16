package com.vn.chungha.pet_kmm.android.presentation.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vn.chungha.pet_kmm.android.navigation.PetNavigationDestination

data object SettingsDestination : PetNavigationDestination {
    override val route = "settings_route"
    override val destination = "settings_destination"
}

fun NavGraphBuilder.settingsGraph() = composable(
    route = SettingsDestination.route
) {
    SettingRoute()
}