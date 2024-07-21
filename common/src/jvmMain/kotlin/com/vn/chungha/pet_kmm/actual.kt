package com.vn.chungha.pet_kmm

import io.ktor.client.engine.java.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single { Java.create() }
}
