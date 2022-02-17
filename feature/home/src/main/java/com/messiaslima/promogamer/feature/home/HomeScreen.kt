package com.messiaslima.promogamer.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.home.composable.HomeNavHost
import com.messiaslima.promogamer.feature.home.composable.AppBottomNavigation

@Composable
fun HomeScreen(
    mainNavController: NavController? = null,
    compositeNavigators: HomeCompositeNavigators? = null,
) {
    val homeNavController = rememberNavController()

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (navHostWrapper, bottomNavigation) = createRefs()

        Box(
            modifier = Modifier.constrainAs(navHostWrapper) {
                top.linkTo(parent.top)
                bottom.linkTo(bottomNavigation.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
        ) {
            if (mainNavController != null && compositeNavigators != null) {
                HomeNavHost(
                    homeNavController = homeNavController,
                    mainNavController = mainNavController,
                    compositeNavigators = compositeNavigators,
                )
            }
        }

        AppBottomNavigation(
            modifier = Modifier.constrainAs(bottomNavigation) {
                bottom.linkTo(parent.bottom)
            },
            homeCompositeNavigators = compositeNavigators,
            currentDestinationRoute = homeNavController.currentDestination?.route,
            onItemClicked = { clickedNavigator ->
                compositeNavigators?.let {
                    performNavigation(homeNavController, clickedNavigator, compositeNavigators)
                }
            }
        )
    }
}

private fun performNavigation(
    homeNavController: NavController,
    clickedNavigator: AppNavigator,
    homeCompositeNavigators: HomeCompositeNavigators,
) {
    if (homeNavController.currentDestination?.route == clickedNavigator.route) return

    homeNavController.navigate(clickedNavigator.route) {
        popUpTo(homeCompositeNavigators.latestDealsNavigator.route)
        launchSingleTop = true
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    PromoGamerTheme {
        Surface {
            HomeScreen()
        }
    }
}
