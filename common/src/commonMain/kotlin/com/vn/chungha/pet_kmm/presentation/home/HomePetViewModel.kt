package com.vn.chungha.pet_kmm.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.vn.chungha.pet_kmm.domain.PetCatRepository
import com.vn.chungha.pet_kmm.domain.mapper.toPetModel
import com.vn.chungha.pet_kmm.domain.model.PetModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class HomePetViewModel : ViewModel(), KoinComponent {

    private val homePetRepository: PetCatRepository by inject()

    private val _statePetModel = MutableStateFlow<List<PetModel>>(emptyList<PetModel>())
    val statePetModel: StateFlow<List<PetModel>> = _statePetModel

    val demo = "Hello KMM! 123 213213 13 12321 3"

    init {
        Logger.d { "HomePetViewModel" }
    }

    private val _messages = MutableStateFlow<String>("Hello")
    val messages: StateFlow<String> = _messages

    init {
        getPetList()
        _messages.value = "Hello KMM!"
    }

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
