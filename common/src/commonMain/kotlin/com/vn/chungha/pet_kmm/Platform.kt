package com.vn.chungha.pet_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform