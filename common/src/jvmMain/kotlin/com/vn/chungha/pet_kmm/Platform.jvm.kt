package com.vn.chungha.pet_kmm

class JvmPlatform : Platform {
  override val name: String = "Jvm"
}

actual fun getPlatform(): Platform = JvmPlatform()
