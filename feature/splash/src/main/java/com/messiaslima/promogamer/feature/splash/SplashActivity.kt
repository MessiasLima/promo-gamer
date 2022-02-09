package com.messiaslima.promogamer.feature.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.messiaslima.promogamer.core.ui.theme.PromoGamerTheme
import com.messiaslima.promogamer.feature.splash.SplashViewModel.UiState
import com.messiaslima.promogamer.feature.splash.ui.PromoGamerSplashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PromoGamerSplashTheme {
                SplashScreen(
                    closeAppAction = {
                        finish()
                    },
                    successAction = {
                        finish()
                    },
                )
            }
        }
    }
}

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel(),
    closeAppAction: () -> Unit,
    successAction: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState(initial = UiState.Loading)

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
        ) {
            LoadingIndicator(
                uiState = uiState,
                closeAppAction = closeAppAction,
                successAction = successAction,
                tryAgainAction = {
                    viewModel.tryAgain()
                }
            )
        }
    }
}

@Composable
fun LoadingIndicator(
    uiState: UiState,
    tryAgainAction: () -> Unit,
    closeAppAction: () -> Unit,
    successAction: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(bottom = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (uiState == UiState.Success) {
            successAction()
        }

        val message = when (uiState) {
            UiState.Error -> R.string.store_synchonization_failure
            UiState.Loading -> R.string.store_synchonization_loading
            UiState.Success -> R.string.store_synchonization_success
        }

        Text(text = stringResource(id = message))

        Spacer(modifier = Modifier.height(16.dp))

        if (uiState == UiState.Loading) {
            LinearProgressIndicator(modifier = Modifier.width(300.dp))
        }

        if (uiState == UiState.Error) {
            Row {
                OutlinedButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp, end = 4.dp),
                    onClick = { closeAppAction() },
                ) {
                    Text(
                        text = stringResource(id = R.string.store_synchonization_close_app),
                    )
                }

                Button(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp, end = 8.dp),
                    onClick = { tryAgainAction() },
                ) {
                    Text(text = stringResource(id = R.string.store_synchonization_try_again))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingIndicatorPreview() {
    PromoGamerTheme {
        LoadingIndicator(UiState.Loading, {}, {}, {})
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingIndicatorPreviewSuccess() {
    PromoGamerTheme {
        LoadingIndicator(UiState.Success, {}, {}, {})
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingIndicatorPreviewError() {
    PromoGamerTheme {
        LoadingIndicator(UiState.Error, {}, {}, {})
    }
}
