package com.messiaslima.promogamer.feature.latestdeals.composable

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.latestdeals.R

@Composable
fun Segment(
    modifier: Modifier = Modifier,
    selectedSegment: Segment = Segment.GAMES,
    onItemClicked: (Segment) -> Unit
) {
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.large),
        elevation = 2.dp
    ) {
        Row {
            Segment.values().forEach {
                SegmentPill(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    text = stringResource(id = it.label),
                    onClick = { onItemClicked(it) },
                    selected = it == selectedSegment
                )
            }
        }
    }
}

enum class Segment(
    @StringRes val label: Int
) {
    GAMES(R.string.games), PRODUCTS(R.string.products)
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview
@Composable
private fun SegmentPreview() {
    PromoGamerTheme {
        Segment {
        }
    }
}
