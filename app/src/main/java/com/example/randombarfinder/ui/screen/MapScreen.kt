package com.example.randombarfinder.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.randombarfinder.viewmodel.BarsUiState
import com.example.randombarfinder.viewmodel.BarsViewModel

@Composable
fun MapScreen(viewModel: BarsViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.loadBars(
            lat = 45.764,
            lon = 4.8357,
            radiusMeters = 30000.0
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is BarsUiState.Idle -> {
                Text(text = "Idle")
            }
            is BarsUiState.Loading -> {
                Text(text = "Loading...")
            }
            is BarsUiState.Success -> {
                val bars = (state as BarsUiState.Success).bars
                Text(text = "Found ${bars.size} bars")
            }
            is BarsUiState.Error -> {
                val message = (state as BarsUiState.Error).message
                Text(text = "Error: $message")
            }
        }
    }
}