package com.vn.chungha.pet_kmm

import io.ktor.client.engine.android.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single { Android.create() }
}

