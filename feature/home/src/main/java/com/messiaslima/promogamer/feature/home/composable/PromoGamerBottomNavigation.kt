package com.messiaslima.promogamer.feature.home.composable

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.home.HomeCompositeNavigators
import com.messiaslima.promogamer.feature.home.R
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Pricetags

@Composable
fun PromoGamerBottomNavigation(
    modifier: Modifier = Modifier,
    homeCompositeNavigators: HomeCompositeNavigators? = null,
    onItemClicked: (navigator: AppNavigator) -> Unit,
    currentDestinationRoute: String? = null
) {
    val items = listOf(
        PromoGamerBottomNavigationItemModel(
            navigator = homeCompositeNavigators?.latestDealsNavigator,
            icon = EvaIcons.Outline.Pricetags,
            iconContentDescription = R.string.latest_deals_icon,
            label = R.string.latest_deals,
            selected = homeCompositeNavigators?.latestDealsNavigator?.route == currentDestinationRoute,
        )
    )

    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = stringResource(id = it.iconContentDescription),
                    )
                },
                label = { Text(text = stringResource(id = it.label)) },
                selected = it.selected,
                onClick = { it.navigator?.let(onItemClicked) },
            )
        }
    }
}

@Preview
@Composable
private fun PromoGamerBottomNavigationPreview() {
    PromoGamerTheme {
        Surface {
            PromoGamerBottomNavigation(onItemClicked = {})
        }
    }
}
