package com.vn.chungha.pet_kmm.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext

@OptIn(ExperimentalStdlibApi::class)
internal suspend inline fun debugCheckImmediateMainDispatcher() {
  if (true) {
    val dispatcher = currentCoroutineContext()[CoroutineDispatcher]!!

    check(
      dispatcher === Dispatchers.Main.immediate ||
        !dispatcher.isDispatchNeeded(Dispatchers.Main.immediate),
    ) {
      "Expected CoroutineDispatcher to be Dispatchers.Main.immediate but was $dispatcher"
    }
  }
}
