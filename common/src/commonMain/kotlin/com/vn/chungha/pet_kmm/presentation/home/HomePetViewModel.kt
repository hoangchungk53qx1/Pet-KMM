package com.vn.chungha.pet_kmm.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vn.chungha.pet_kmm.domain.PetCatRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

open class HomePetViewModel(
    private val homePetRepository: PetCatRepository
) : ViewModel(), KoinComponent {

    fun getPetList() {
        viewModelScope.launch {
            homePetRepository.getPetCatByPage("breed:", 1, 10)
        }
    }

    companion object {
        const val TAG = "HomePetViewModel"
    }
}
