package com.example.randombarfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.randombarfinder.data.remote.createPlacesService
import com.example.randombarfinder.data.repository.BarsRepositoryImpl
import com.example.randombarfinder.ui.screen.MapScreen
import com.example.randombarfinder.ui.theme.RandomBarFinderTheme
import com.example.randombarfinder.viewmodel.BarsViewModel
import com.example.randombarfinder.viewmodel.BarsViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val service = createPlacesService(BuildConfig.MAPS_API_KEY)
        val repository = BarsRepositoryImpl(service)
        val factory = BarsViewModelFactory(repository)

        setContent {
            RandomBarFinderTheme {
                val viewModel: BarsViewModel = viewModel(factory = factory)
                MapScreen(viewModel)
            }
        }
    }
}