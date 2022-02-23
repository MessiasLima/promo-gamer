package com.messiaslima.promogamer.feature.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.home.composable.AppBottomNavigation
import com.messiaslima.promogamer.feature.home.composable.HomeNavHost

@Composable
fun HomeScreen(
    mainNavController: NavController? = null,
    compositeNavigators: HomeCompositeNavigators? = null,
) {
    val homeNavController = rememberNavController()

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (navHostWrapper, bottomNavigation) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(navHostWrapper) {
                    top.linkTo(parent.top)
                    bottom.linkTo(bottomNavigation.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
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
                top.linkTo(navHostWrapper.bottom)
            },
            compositeNavigators = compositeNavigators,
            homeNavController = homeNavController
        ) { clickedNavigator ->
            compositeNavigators?.let {
                performNavigation(homeNavController, clickedNavigator, compositeNavigators)
            }
        }
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

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    PromoGamerTheme {
        Surface {
            HomeScreen()
        }
    }
}
