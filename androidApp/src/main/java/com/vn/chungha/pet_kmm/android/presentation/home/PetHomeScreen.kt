package com.vn.chungha.pet_kmm.android.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vn.chungha.pet_kmm.domain.model.PetModel
import com.vn.chungha.pet_kmm.presentation.home.HomePetViewModel
import kotlinx.collections.immutable.toImmutableList
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PetHomeRoute() {
    val playerListViewModel = koinViewModel<HomePetViewModel>()

    val stateUiPetModel: State<List<PetModel>> =
        playerListViewModel.statePetModel.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        playerListViewModel.getPetList()
    }
    PetHomeScreen(
        modifier = Modifier,
        items = stateUiPetModel.value
    )
}

@Composable
fun PetHomeScreen(modifier: Modifier,items : List<PetModel>) {
    val playerListViewModel = koinViewModel<HomePetViewModel>()

    LaunchedEffect(Unit) {
        playerListViewModel.getPetList()
    }

    Box(modifier = modifier) {
        PetCatItemsList(
            items = items.toImmutableList(),
            isLoading = false,
            onNextPage = { playerListViewModel.getPetList() },
            modifier = Modifier
        )
    }
}
