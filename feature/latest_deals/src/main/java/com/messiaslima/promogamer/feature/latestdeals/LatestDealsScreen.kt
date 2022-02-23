package com.messiaslima.promogamer.feature.latestdeals

import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.core.ui.component.segment.SegmentItemModel
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.latestdeals.composable.LatestDealsTopBar

@Composable
fun LatestDealsScreen(
    mainNavController: NavController,
    compositeNavigator: LatestDealsCompositeNavigator? = null
) {
    val latestDealsNavController = rememberNavController()
    val navBackStackEntry by latestDealsNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val segmentItems = listOf(
        SegmentItemModel(
            label = stringResource(id = R.string.games),
            isSelected = isSelected(
                currentDestination,
                compositeNavigator?.latestDealsGamesNavigator
            ),
            navigator = compositeNavigator?.latestDealsGamesNavigator
        ),
        SegmentItemModel(
            label = stringResource(id = R.string.products),
            isSelected = isSelected(
                currentDestination,
                compositeNavigator?.latestDealsProductsNavigator
            ),
            navigator = compositeNavigator?.latestDealsProductsNavigator
        )
    )

    Scaffold(
        topBar = {
            LatestDealsTopBar(
                segmentItems = segmentItems,
                latestDealsNavController = latestDealsNavController
            )
        },
        content = {
            compositeNavigator?.let {
                NavHost(
                    navController = latestDealsNavController,
                    startDestination = compositeNavigator.latestDealsGamesNavigator.route
                ) {
                    compositeNavigator.latestDealsGamesNavigator.configure(
                        navGraphBuilder = this,
                        navController = mainNavController
                    )

                    compositeNavigator.latestDealsProductsNavigator.configure(
                        navGraphBuilder = this,
                        navController = mainNavController
                    )
                }
            }
        }
    )
}

private fun isSelected(
    currentDestination: NavDestination?,
    appNavigator: AppNavigator?
) = currentDestination?.hierarchy?.any { it.route == appNavigator?.route } == true

@Preview
@Composable
fun LatestDealsScreenPreview() {
    PromoGamerTheme {
        Surface {
            val navController = rememberNavController()

            LatestDealsScreen(navController)
        }
    }
}
