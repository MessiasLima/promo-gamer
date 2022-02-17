package com.messiaslima.promogamer.feature.saveddeals

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme

@Composable
fun SavedDealsScreen() {
    Text(text = "This is saved deals screen")
}

@Preview
@Composable
fun SavedDealsScreenPreview() {
    PromoGamerTheme {
        Surface {
            SavedDealsScreen()
        }
    }
}
