package com.vn.chungha.pet_kmm.presentation.home

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

open class HomePetViewModel(
//    private val homePetRepository: HomePetRepository
) : ViewModel(), KoinComponent {

    companion object {
        const val TAG = "HomePetViewModel"
    }
}