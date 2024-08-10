package com.vn.chungha.pet_kmm.data.mapper

import com.vn.chungha.pet_kmm.data.remote.response.PetCatResponse
import com.vn.chungha.pet_kmm.domain.model.PetModel

fun PetCatResponse.toPetCat() = PetModel(
    id = id,
    name = name,
    description = description,
    url = image.url
)
