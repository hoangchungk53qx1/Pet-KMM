package com.vn.chungha.pet_kmm.domain

import com.github.michaelbull.result.Result
import com.vn.chungha.pet_kmm.domain.model.PetModel

interface PetCatRepository {
  suspend fun getPetCatByPage(query: String, page: Int, perPage: Int): Result<List<PetModel>, Throwable>
}
