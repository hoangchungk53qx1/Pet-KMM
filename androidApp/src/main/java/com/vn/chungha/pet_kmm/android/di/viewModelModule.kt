package com.vn.chungha.pet_kmm.android.di

import com.vn.chungha.pet_kmm.presentation.home.HomePetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { HomePetViewModel() }
}