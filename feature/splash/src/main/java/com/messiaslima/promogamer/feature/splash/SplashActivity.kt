package com.messiaslima.promogamer.feature.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.splash.ui.PromoGamerSplashTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PromoGamerSplashTheme {
                SplashScreen()
            }
        }
    }
}

@Composable
fun SplashScreen(viewModel: SplashViewModel = viewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
        ) {
            LoadingIndicator(message = viewModel.message)
        }
    }
}

@Composable
fun LoadingIndicator(message: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = message)

        LinearProgressIndicator(
            modifier = Modifier
                .width(300.dp)
                .padding(top = 16.dp, bottom = 48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingIndicatorPreview() {
    PromoGamerTheme {
        LoadingIndicator("Preview message")
    }
}
