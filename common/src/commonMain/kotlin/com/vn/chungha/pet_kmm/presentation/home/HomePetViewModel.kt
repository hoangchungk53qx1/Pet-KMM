package com.vn.chungha.pet_kmm.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.github.michaelbull.result.fold
import com.vn.chungha.pet_kmm.domain.PetCatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class HomePetViewModel : ViewModel(), KoinComponent {

  private val homePetRepository: PetCatRepository by inject()

  private val _statePetModel = MutableStateFlow<HomePetUiState>(HomePetUiState.LoadingFirstPage)
  val statePetModel: StateFlow<HomePetUiState> = _statePetModel.asStateFlow()

  init {
    Logger.d { "HomePetViewModel" }
    getPetFirstList()
  }

  fun getPetFirstList() {
    _statePetModel.value = HomePetUiState.LoadingFirstPage

    viewModelScope.launch {
      homePetRepository.getPetCatByPage(
        QUERY, FIRST_PAGE, PAGE_SIZE
      ).fold(
        success = {
          Logger.d { "getPetFirstList success" }
          _statePetModel.value = HomePetUiState.LoadPageSuccess(
            currentPage = FIRST_PAGE,
            petList = it,
            nextPageState = HomePetUiState.NextPageState.Idle,
          )
        },
        failure = {
          Logger.d { "getPetFirstList Failure" }
          _statePetModel.value = HomePetUiState.FirstPageError
        },
      )
    }
  }

  fun loadNextPage() {
    val currentState = _statePetModel.value
    if (currentState !is HomePetUiState.LoadPageSuccess) {
      return
    }

    viewModelScope.launch {
      val nextPage = currentState.currentPage + 1
      _statePetModel.value = currentState.copy(nextPageState = HomePetUiState.NextPageState.Loading)

      if (currentState.nextPageState != HomePetUiState.NextPageState.Idle) {
        return@launch
      }

      homePetRepository.getPetCatByPage(query = QUERY, page = nextPage, perPage = PAGE_SIZE)
        .fold(
          success = {
            _statePetModel.value = HomePetUiState.LoadPageSuccess(
              currentPage = nextPage,
              petList = currentState.petList + it,
              nextPageState = HomePetUiState.NextPageState.Idle,
            )
          },
          failure = {
            _statePetModel.update {
              currentState.copy(nextPageState = HomePetUiState.NextPageState.Error)
            }
          },
        )
    }
  }

  companion object {
    private const val TAG = "HomePetViewModel"
    private const val PAGE_SIZE = 10
    private const val QUERY = "breed"
    private const val FIRST_PAGE = 1
  }
}
