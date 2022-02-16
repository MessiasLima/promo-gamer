package com.messiaslima.promogamer.feature.home.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.messiaslima.promogamer.core.navigation.contract.AppNavigator
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.home.R
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Pricetags

@Composable
fun RowScope.PromoGamerBottomNavigationItem(
    model: PromoGamerBottomNavigationItemModel,
    onItemClicked: (AppNavigator) -> Unit
) {
    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = model.icon,
                contentDescription = stringResource(id = model.iconContentDescription),
            )
        },
        label = { Text(text = stringResource(id = model.label)) },
        selected = model.selected,
        onClick = { model.navigator?.let(onItemClicked) },
        selectedContentColor = MaterialTheme.colors.primary,
        unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
    )
}

@Preview
@Composable
private fun PromoGamerBottomNavigationItemPreview() {
    val model = PromoGamerBottomNavigationItemModel(
        navigator = null,
        icon = EvaIcons.Outline.Pricetags,
        iconContentDescription = R.string.latest_deals_icon,
        label = R.string.latest_deals,
        selected = false
    )

    PromoGamerTheme {
        Surface {
            Row {
                PromoGamerBottomNavigationItem(model = model) {}
                PromoGamerBottomNavigationItem(model = model.copy(selected = true)) {}
            }
        }
    }
}

data class PromoGamerBottomNavigationItemModel(
    val navigator: AppNavigator?,
    val icon: ImageVector,
    @StringRes val iconContentDescription: Int,
    @StringRes val label: Int,
    val selected: Boolean
)
