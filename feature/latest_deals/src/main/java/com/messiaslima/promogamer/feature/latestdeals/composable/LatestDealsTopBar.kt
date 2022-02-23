package com.messiaslima.promogamer.feature.latestdeals.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.messiaslima.promogamer.core.ui.component.segment.Segment
import com.messiaslima.promogamer.core.ui.component.segment.SegmentItemModel
import com.messiaslima.promogamer.feature.latestdeals.R

@Composable
fun LatestDealsTopBar(
    segmentItems: List<SegmentItemModel>,
    latestDealsNavController: NavController
) {
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
            onItemClicked = {
                it.navigator?.route?.let { route ->
                    latestDealsNavController.navigate(route) {
                        popUpTo(latestDealsNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
        )
    }
}
