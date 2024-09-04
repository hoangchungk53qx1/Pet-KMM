package com.vn.chungha.pet_kmm.android.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vn.chungha.pet_kmm.domain.model.PetModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.filter

@Composable
fun PetCatItemsList(
  items: ImmutableList<PetModel>,
  isLoading: Boolean,
  hasReachedMax: Boolean,
  onNextPage: () -> Unit,
  modifier: Modifier,
  lazyListState: LazyListState = rememberLazyListState(),
) {
  val rememberOnLoadMore by rememberUpdatedState(onNextPage)
  val currentHasReachedMax by rememberUpdatedState(hasReachedMax)

  LaunchedEffect(key1 = lazyListState) {
    snapshotFlow { lazyListState.layoutInfo }
      .filter {
        val index = it.visibleItemsInfo.lastOrNull()?.index
        val totalItemsCount = it.totalItemsCount

        !isLoading && !currentHasReachedMax && index != null && index >= totalItemsCount - 1
      }
      .collect {
        rememberOnLoadMore()
      }
  }
  LazyColumn(
    modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    state = lazyListState,
  ) {
    items(items.size) { index ->
      val item = items[index]
      PetCatItemRow(
          petInfo = item,
          imageHeight = 60.dp,
          modifier = Modifier,
      )
    }
  }
}
