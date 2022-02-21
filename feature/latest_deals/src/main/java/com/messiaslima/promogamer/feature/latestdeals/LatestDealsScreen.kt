package com.messiaslima.promogamer.feature.latestdeals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.latestdeals.composable.Segment

@Composable
fun LatestDealsScreen() {
    val latestDealsNavController = rememberNavController()

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.promo_gamer),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Segment(onItemClicked = {})
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
