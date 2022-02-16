package com.messiaslima.promogamer.feature.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(homeViewModelFactory: HomeViewModelFactory) {
    val viewModel = viewModel<HomeViewModel>(factory = homeViewModelFactory)
    Text(text = "This is home screen")
    Text(text = viewModel.getMessage())
}
