package com.vn.chungha.pet_kmm.data.remote

import com.vn.chungha.pet_kmm.data.remote.response.PetCatResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PetApi(
  private val baseUrl: String = "https://api.thecatapi.com/v1",
  private val apiKey: String,
  private val client: HttpClient,
) {

  suspend fun fetchPetHomeByBreedPage() = client
    .get("$baseUrl/breeds?attach_breed=0&page=1&limit=10").body<List<PetCatResponse>>()
}
