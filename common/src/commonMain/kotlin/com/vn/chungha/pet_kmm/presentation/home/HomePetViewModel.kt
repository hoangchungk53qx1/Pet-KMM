package com.vn.chungha.pet_kmm.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vn.chungha.pet_kmm.domain.mapper.toPetModel
import com.vn.chungha.pet_kmm.domain.model.PetModel
import com.vn.chungha.pet_kmm.domain.repository.PetCatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

open class HomePetViewModel(
    private val homePetRepository: PetCatRepository
) : ViewModel(), KoinComponent {

    private val _statePetModel = MutableStateFlow<List<PetModel>>(emptyList())
    val statePetModel = _statePetModel.asStateFlow()

    fun getPetList() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                homePetRepository.getPetCatByPage("breed", 1, 10)
            }
            _statePetModel.value = result.map { it.toPetModel() }
        }
    }


    companion object {
        const val TAG = "HomePetViewModel"
    }
}
