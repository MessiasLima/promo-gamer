package com.messiaslima.promogamer.core.ui.component.segment

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun Segment(
    modifier: Modifier = Modifier,
    items: List<SegmentItemModel> = emptyList(),
    onItemClicked: (SegmentItemModel) -> Unit
) {
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.large),
        elevation = 2.dp
    ) {
        Row {
            items.forEach {
                SegmentPill(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    text = it.label,
                    onClick = { onItemClicked(it) },
                    selected = it.isSelected
                )
            }
        }
    }
}

data class SegmentItemModel(
    val label: String,
    val isSelected: Boolean,
    val navigator: AppNavigator? = null,
)

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview
@Composable
private fun SegmentPreview() {
    PromoGamerTheme {
        val itemGames = SegmentItemModel(
            label = "Games",
            isSelected = false,
        )

        val itemProducts = SegmentItemModel(
            label = "Products",
            isSelected = true,
        )

        val previewItems = listOf(
            itemGames,
            itemProducts
        )
        Segment(items = previewItems) {}
    }
}
