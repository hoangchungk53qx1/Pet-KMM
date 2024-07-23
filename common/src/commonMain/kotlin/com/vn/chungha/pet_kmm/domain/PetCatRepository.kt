package com.vn.chungha.pet_kmm.domain

import com.vn.chungha.pet_kmm.data.remote.response.PetCatResponse

interface PetCatRepository {
  suspend fun getPetCatByPage(query: String, page: Int, perPage: Int): List<PetCatResponse>
}
