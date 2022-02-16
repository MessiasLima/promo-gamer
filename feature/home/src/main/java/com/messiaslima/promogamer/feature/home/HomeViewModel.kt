package com.messiaslima.promogamer.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeOrchestrator: HomeOrchestrator) :
    ViewModel()