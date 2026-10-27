package com.example.randombarfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randombarfinder.data.repository.BarsRepository
import com.example.randombarfinder.model.Bar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface BarsUiState {
    data object Idle : BarsUiState
    data object Loading : BarsUiState
    data class Success(val bars: List<Bar>) : BarsUiState
    data class Error(val message: String) : BarsUiState
}

class BarsViewModel(private val repository: BarsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<BarsUiState>(BarsUiState.Idle)
    val uiState: StateFlow<BarsUiState> = _uiState.asStateFlow()

    fun loadBars(lat: Double, lon: Double, radiusMeters: Double) {
        viewModelScope.launch {
            _uiState.value = BarsUiState.Loading
            repository.getNearbyBars(lat, lon, radiusMeters).fold(
                onSuccess = { bars -> _uiState.value = BarsUiState.Success(bars) },
                onFailure = { e -> _uiState.value = BarsUiState.Error(e.message ?: "Erreur inconnue") }
            )
        }
    }
}