package com.vn.chungha.pet_kmm.presentation.home

import com.vn.chungha.pet_kmm.domain.model.PetModel
import kotlinx.collections.immutable.ImmutableList

sealed interface HomePetUiState {
  data object LoadingFirstPage : HomePetUiState

  data object FirstPageError : HomePetUiState

  data class LoadPageSuccess(
    val currentPage: Int,
    val petList: List<PetModel>,
    val nextPageState: NextPageState,
  ) : HomePetUiState


  sealed interface NextPageState {
    data object Loading : NextPageState
    data object Idle : NextPageState
    data object Error : NextPageState
    data object Done : NextPageState
  }
}

