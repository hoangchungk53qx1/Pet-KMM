package com.vn.chungha.pet_kmm.android.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.vn.chungha.pet_kmm.presentation.home.HomePetViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PetHomeRoute() {
    PetHomeScreen(
        modifier = Modifier,
    )
}

@Composable
fun PetHomeScreen(modifier: Modifier) {
    val playerListViewModel = koinViewModel<HomePetViewModel>()

    LaunchedEffect(Unit) {
        playerListViewModel.getPetList()
    }

    Box(modifier = modifier) {
        Text(text = "Pet Home Screen")
    }
}
