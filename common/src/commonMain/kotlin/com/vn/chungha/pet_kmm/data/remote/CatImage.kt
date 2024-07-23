package com.vn.chungha.pet_kmm.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class CatImage(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String
)