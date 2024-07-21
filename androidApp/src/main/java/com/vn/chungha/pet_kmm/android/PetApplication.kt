package com.vn.chungha.pet_kmm.android

import android.app.Application
import com.vn.chungha.pet_kmm.android.di.viewModelModules
import com.vn.chungha.pet_kmm.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class PetApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@PetApplication)
            modules(viewModelModules)
        }

    }
}
