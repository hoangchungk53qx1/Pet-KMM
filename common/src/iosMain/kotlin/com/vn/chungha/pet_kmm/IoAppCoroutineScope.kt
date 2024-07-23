package com.vn.chungha.pet_kmm

import com.vn.chungha.pet_kmm.utils.AppCoroutineDispatchers
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.core.module.dsl.new

val IoAppCoroutineScope = named("IoAppCoroutineScope")
val MainAppCoroutineScope = named("MainAppCoroutineScope")

val AppModule = module {
  singleOf(::IosAppCoroutineDispatchers) {
    bind<AppCoroutineDispatchers>()
  }

  single<AppCoroutineScope>(IoAppCoroutineScope) {
    new(::IoAppCoroutineScopeImpl)
  }

  single<AppCoroutineScope>(MainAppCoroutineScope) {
    new(::MainAppCoroutineScopeImpl)
  }
}