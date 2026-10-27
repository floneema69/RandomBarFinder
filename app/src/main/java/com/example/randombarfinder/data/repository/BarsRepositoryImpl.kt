package com.example.randombarfinder.data.repository

import PlacesService
import com.example.randombarfinder.data.mapper.toBars
import com.example.randombarfinder.data.remote.dto.CircleDto
import com.example.randombarfinder.data.remote.dto.LatLngDto
import com.example.randombarfinder.data.remote.dto.LocationRestrictionDto
import com.example.randombarfinder.data.remote.dto.SearchNearbyRequest
import com.example.randombarfinder.model.Bar

class BarsRepositoryImpl(private val service: PlacesService) : BarsRepository {
    override suspend fun getNearbyBars(lat: Double, lon: Double, radiusMeters: Double): Result<List<Bar>> {
        return try {
            val request = SearchNearbyRequest(
                includedTypes = listOf("bar"),
                maxResultCount = 20,
                languageCode = "fr",
                locationRestriction = LocationRestrictionDto(
                    circle = CircleDto(
                        center = LatLngDto(latitude = lat, longitude = lon),
                        radius = radiusMeters
                    )
                )
            )
            val response = service.searchNearby(request)
            Result.success(response.toBars())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }}