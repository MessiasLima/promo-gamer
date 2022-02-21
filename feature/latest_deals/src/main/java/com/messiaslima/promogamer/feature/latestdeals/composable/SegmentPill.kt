package com.messiaslima.promogamer.feature.latestdeals.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun SegmentPill(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    text: String = "",
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) MaterialTheme.colors.primary else Color.Transparent

    val contentColor =
        if (selected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface

    val roundedCorner = MaterialTheme.shapes.large

    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = roundedCorner)
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            textAlign = TextAlign.Center,
            color = contentColor
        )
    }
}

@Preview
@Composable
private fun SegmentPillPreview() {
    PromoGamerTheme {
        Row {
            var selected by remember {
                mutableStateOf(true)
            }

            val invertSelected = {
                selected = !selected
            }

            SegmentPill(
                modifier = Modifier.weight(1f),
                selected = selected,
                text = "Games",
                onClick = invertSelected
            )

            SegmentPill(
                modifier = Modifier.weight(1f),
                selected = !selected,
                text = "Products",
                onClick = invertSelected
            )
        }
    }
}
