package com.vn.chungha.pet_kmm.android.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vn.chungha.pet_kmm.domain.model.PetModel

@Composable
internal fun PetCatItemRow(
    petInfo: PetModel,
    imageHeight: Dp,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        val context = LocalContext.current
        AsyncImage(
            model = remember {
                ImageRequest.Builder(context)
                    .data(petInfo.url)
                    .crossfade(true)
                    .build()
            },
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            contentDescription = "${petInfo.name} image",
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight)
        )

        Text(
            text = petInfo.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, top = 10.dp, end = 16.dp)
        )

        Text(
            text = petInfo.description,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75F),
            maxLines = 2,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, top = 2.dp, end = 16.dp, bottom = 20.dp)
        )
    }
}