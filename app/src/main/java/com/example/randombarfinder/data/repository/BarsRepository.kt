package com.example.randombarfinder.data.repository

import com.example.randombarfinder.model.Bar

interface BarsRepository {
    suspend fun getNearbyBars(lat: Double, lon: Double, radiusMeters: Double): Result<List<Bar>>
}