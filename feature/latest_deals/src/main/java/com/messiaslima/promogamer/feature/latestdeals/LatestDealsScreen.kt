package com.messiaslima.promogamer.feature.latestdeals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.ui.component.segment.Segment
import com.messiaslima.promogamer.core.ui.component.segment.SegmentItemModel
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun LatestDealsScreen() {
    val latestDealsNavController = rememberNavController()
    val segmentItems = listOf(
        SegmentItemModel(
            label = stringResource(id = R.string.games),
            isSelected = true
        ),
        SegmentItemModel(
            label = stringResource(id = R.string.products),
            isSelected = false
        )
    )

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.surface,
                    title = {
                        Text(text = stringResource(id = R.string.promo_gamer))
                    },
                    elevation = 0.dp
                )
                Segment(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    items = segmentItems,
                    onItemClicked = {},
                )
            }
        },
        content = {}
    )
}

@Preview
@Composable
fun LatestDealsScreenPreview() {
    PromoGamerTheme {
        Surface {
            LatestDealsScreen()
        }
    }
}
