package com.vn.chungha.pet_kmm.presentation.home

import androidx.compose.runtime.Immutable
import com.vn.chungha.pet_kmm.domain.model.PetModel
import kotlinx.collections.immutable.ImmutableList


@Immutable
data class HomePetUiState(
    val isLoading : Boolean,
    val isFirstPage : Boolean,
    val currentPage : Int,
    val petList : List<PetModel>,
    val error : String
)
