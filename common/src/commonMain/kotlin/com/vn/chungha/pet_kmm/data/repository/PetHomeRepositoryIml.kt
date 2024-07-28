package com.vn.chungha.pet_kmm.data.repository

import com.vn.chungha.pet_kmm.data.remote.PetApi
import com.vn.chungha.pet_kmm.data.remote.response.PetCatResponse
import com.vn.chungha.pet_kmm.domain.PetCatRepository

class PetHomeRepositoryIml(private val petApi: PetApi) : PetCatRepository {
    override suspend fun getPetCatByPage(
        query: String,
        page: Int,
        perPage: Int
    ): List<PetCatResponse> =
        petApi.fetchPetHomeByBreedPage(0, 20)
}
