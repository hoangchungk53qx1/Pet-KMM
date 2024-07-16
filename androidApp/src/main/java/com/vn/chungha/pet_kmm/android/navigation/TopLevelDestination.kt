package com.vn.chungha.pet_kmm.android.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.vn.chungha.pet_kmm.android.R
import com.vn.chungha.pet_kmm.android.presentation.favorite.FavoriteDestination
import com.vn.chungha.pet_kmm.android.presentation.home.PetHomeDestination
import com.vn.chungha.pet_kmm.android.presentation.settings.SettingsDestination

enum class TopLevelDestination(
  override val route: String,
  override val destination: String,
  @DrawableRes val iconResourceId: Int,
  @DrawableRes val iconResourceSelect: Int,
  @StringRes val textResourceId: Int,
) : PetNavigationDestination {
  PetHome(
    route = PetHomeDestination.route,
    destination = PetHomeDestination.destination,
    iconResourceId = R.drawable.baseline_home_24,
    iconResourceSelect = R.drawable.baseline_home_24,
    textResourceId = R.string.title_home,
  ),
  Favorite(
    route = FavoriteDestination.route,
    destination = FavoriteDestination.destination,
    iconResourceId = R.drawable.baseline_favorite_24,
    iconResourceSelect = R.drawable.baseline_favorite_24,
    textResourceId = R.string.title_favorite,
  ),
  Settings(
    route = SettingsDestination.route,
    destination = SettingsDestination.destination,
    iconResourceId = R.drawable.baseline_settings_24,
    iconResourceSelect = R.drawable.baseline_settings_24,
    textResourceId = R.string.title_settings,
  ),
}
