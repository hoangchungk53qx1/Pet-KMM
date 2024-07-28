package com.vn.chungha.pet_kmm.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class PetCatResponse(
  val id: String,
  val name: String,
  val description: String,
  val image : CatImage,
)
