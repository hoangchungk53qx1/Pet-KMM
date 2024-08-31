package com.vn.chungha.pet_kmm.data.repository

import co.touchlab.kermit.Logger
import com.github.michaelbull.result.coroutines.runSuspendCatching
import com.github.michaelbull.result.Result
import com.vn.chungha.pet_kmm.data.remote.PetApi
import com.vn.chungha.pet_kmm.domain.PetCatRepository
import com.vn.chungha.pet_kmm.domain.mapper.toPetModel
import com.vn.chungha.pet_kmm.domain.model.PetModel
import com.vn.chungha.pet_kmm.utils.AppCoroutineDispatchers
import kotlinx.coroutines.withContext

class PetHomeRepositoryIml(
  private val petApi: PetApi,
  private val appCoroutineDispatchers: AppCoroutineDispatchers,
) :
  PetCatRepository {
  override suspend fun getPetCatByPage(
    query: String,
    page: Int,
    perPage: Int,
  ): Result<List<PetModel>, Throwable> {
    return withContext(appCoroutineDispatchers.io) {
      runSuspendCatching {
        petApi.fetchPetHomeByBreedPage(page, perPage).map {
          Logger.d { "getPetCatByPage success" }
          it.toPetModel()
        }
      }
    }
  }
}
