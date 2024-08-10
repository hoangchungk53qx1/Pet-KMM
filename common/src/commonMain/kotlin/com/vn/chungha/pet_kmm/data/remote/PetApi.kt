package com.vn.chungha.pet_kmm.data.remote

import com.vn.chungha.pet_kmm.data.remote.response.PetCatResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.component.KoinComponent

class PetApi(
  private val baseUrl: String,
  private val client: HttpClient,
) : KoinComponent {

  suspend fun fetchPetHomeByBreedPage(page: Int, limit : Int): List<PetCatResponse> = client
    .get("$baseUrl/breeds?attach_breed=0&page=$page&limit=$limit").body<List<PetCatResponse>>()
}
