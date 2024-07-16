package com.vn.chungha.pet_kmm

class Greeting {
  private val platform: Platform = getPlatform()

  fun greet(): String = "Hello, ${platform.name}!"
}
