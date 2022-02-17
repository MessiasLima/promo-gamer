package com.messiaslima.promogamer.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.home.composable.PromoGamerBottomNavigation

@Composable
fun HomeScreen(
    mainNavController: NavController? = null,
    compositeNavigators: HomeCompositeNavigators? = null,
    showNavHost: Boolean = true
) {
    val homeNavController = rememberNavController()

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (navHost, bottomNavigation) = createRefs()
        Box(
            modifier = Modifier.constrainAs(navHost) {
                top.linkTo(parent.top)
                bottom.linkTo(bottomNavigation.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
        ) {
            if (showNavHost) {
                NavHost(
                    navController = homeNavController,
                    startDestination = compositeNavigators?.latestDealsNavigator?.route ?: "home"
                ) {
                    mainNavController?.let {
                        compositeNavigators?.latestDealsNavigator?.configure(
                            navGraphBuilder = this,
                            navController = mainNavController
                        )

                        compositeNavigators?.savedDealsNavigator?.configure(
                            navGraphBuilder = this,
                            navController = mainNavController,
                        )
                    }
                }
            }
        }

        PromoGamerBottomNavigation(
            modifier = Modifier.constrainAs(bottomNavigation) {
                bottom.linkTo(parent.bottom)
            },
            homeCompositeNavigators = compositeNavigators,
            currentDestinationRoute = homeNavController.currentDestination?.route,
            onItemClicked = {
                homeNavController.navigate(it.route)
            }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    PromoGamerTheme {
        Surface {
            HomeScreen(showNavHost = false)
        }
    }
}
