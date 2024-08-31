package com.vn.chungha.pet_kmm.android.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vn.chungha.pet_kmm.domain.model.PetModel
import com.vn.chungha.pet_kmm.presentation.home.HomePetUiState
import com.vn.chungha.pet_kmm.presentation.home.HomePetViewModel
import kotlinx.collections.immutable.toImmutableList
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PetHomeRoute() {
    val playerListViewModel = koinViewModel<HomePetViewModel>()

    val stateUiPetModel: State<HomePetUiState> =
        playerListViewModel.statePetModel.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        playerListViewModel.getPetFirstList()
    }
    PetHomeScreen(
        modifier = Modifier,
        items = if (stateUiPetModel.value is HomePetUiState.LoadPageSuccess) {
            (stateUiPetModel.value as HomePetUiState.LoadPageSuccess).petList
        } else {
            emptyList()
        }
    )
}

@Composable
fun PetHomeScreen(modifier: Modifier,items : List<PetModel>) {
    val playerListViewModel = koinViewModel<HomePetViewModel>()

    Box(modifier = modifier) {
        PetCatItemsList(
            items = items.toImmutableList(),
            isLoading = false,
            onNextPage = { playerListViewModel.loadNextPage() },
            modifier = Modifier
        )
    }
}
