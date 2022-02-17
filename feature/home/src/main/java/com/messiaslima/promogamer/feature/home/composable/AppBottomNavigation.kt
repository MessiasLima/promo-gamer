package com.messiaslima.promogamer.feature.home.composable

import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.home.HomeCompositeNavigators
import com.messiaslima.promogamer.feature.home.R
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Heart
import compose.icons.evaicons.outline.Pricetags

@Composable
fun AppBottomNavigation(
    modifier: Modifier = Modifier,
    compositeNavigators: HomeCompositeNavigators?,
    homeNavController: NavController,
    onItemClicked: (navigator: AppNavigator) -> Unit,
) {
    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        AppBottomNavigationItemModel(
            navigator = compositeNavigators?.latestDealsNavigator,
            icon = EvaIcons.Outline.Pricetags,
            iconContentDescription = R.string.latest_deals_icon,
            label = R.string.latest_deals,
            selected = isSelected(currentDestination, compositeNavigators?.latestDealsNavigator),
        ),

        AppBottomNavigationItemModel(
            navigator = compositeNavigators?.savedDealsNavigator,
            icon = EvaIcons.Outline.Heart,
            iconContentDescription = R.string.saved_deals_icon,
            label = R.string.saved_deals,
            selected = isSelected(currentDestination, compositeNavigators?.savedDealsNavigator),
        )
    )

    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        items.forEach {
            AppBottomNavigationItem(model = it, onItemClicked = onItemClicked)
        }
    }
}

private fun isSelected(
    currentDestination: NavDestination?,
    appNavigator: AppNavigator?
) = currentDestination?.hierarchy?.any { it.route == appNavigator?.route } == true

@Preview
@Composable
fun PromoGamerBottomNavigationPreview() {
    PromoGamerTheme {
        Surface {
        }
    }
}
