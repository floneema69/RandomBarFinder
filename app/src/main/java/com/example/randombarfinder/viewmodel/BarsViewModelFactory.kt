package com.example.randombarfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randombarfinder.data.repository.BarsRepository

class BarsViewModelFactory(
    private val repository: BarsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BarsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BarsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}