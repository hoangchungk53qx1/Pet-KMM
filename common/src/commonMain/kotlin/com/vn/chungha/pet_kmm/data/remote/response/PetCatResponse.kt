package com.vn.chungha.pet_kmm.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class PetCatResponse(
  val id: String,
  val name: String,
  val description: String,
  val temperament: String,
  val origin: String,
  val life_span: String,
  val wikipedia_url: String,
)
