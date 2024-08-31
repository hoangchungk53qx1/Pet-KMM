package com.vn.chungha.pet_kmm.di

import com.vn.chungha.pet_kmm.buildkonfig.BuildKonfig
import com.vn.chungha.pet_kmm.data.repository.PetHomeRepositoryIml
import com.vn.chungha.pet_kmm.data.remote.PetApi
import com.vn.chungha.pet_kmm.domain.PetCatRepository
import com.vn.chungha.pet_kmm.platformModule
import com.vn.chungha.pet_kmm.presentation.home.HomePetViewModel
import com.vn.chungha.pet_kmm.utils.AppCoroutineDispatcherImpl
import com.vn.chungha.pet_kmm.utils.AppCoroutineDispatchers
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) = startKoin {
  appDeclaration()
  modules(commonModule(enableNetworkLogs = enableNetworkLogs), platformModule())
}

// called by iOS etc
fun initKoin() = initKoin(enableNetworkLogs = false) {}

private fun getBaseUrlDomain() = BuildKonfig.API_DOMAIN

fun commonModule(enableNetworkLogs: Boolean) = module {
  factory(qualifier = named("baseUrl")) { getBaseUrlDomain() }
  single { createJson() }
  single<AppCoroutineDispatchers> { AppCoroutineDispatcherImpl() }
  single { createHttpClient(get(), get(), enableNetworkLogs = enableNetworkLogs) }
  single { PetApi(get(qualifier = named("baseUrl")), get()) }
  single<PetCatRepository> { PetHomeRepositoryIml(get(), get()) }
  viewModel { HomePetViewModel() }
}

fun createJson() = Json {
  isLenient = true
  ignoreUnknownKeys = true
}

fun createHttpClient(httpClientEngine: HttpClientEngine, json: Json, enableNetworkLogs: Boolean) = HttpClient(
  httpClientEngine,
) {
  install(ContentNegotiation) {
    json(json)
  }

  install(DefaultRequest) {
    header("Content-Type", "application/json")
    header("x-api-key", BuildKonfig.API_KEY_DEMO)
  }

  install(HttpTimeout) {
    requestTimeoutMillis = 15_000
    connectTimeoutMillis = 10_000
    socketTimeoutMillis = 10_000
  }

  if (enableNetworkLogs) {
    install(Logging) {
      logger = Logger.DEFAULT
      level = LogLevel.ALL
    }
  }
}
