package com.example.randombarfinder.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LatLngDto(
        val latitude: Double,
        val longitude: Double
)

@Serializable
data class CircleDto(
        val center: LatLngDto,
        val radius: Double
)

@Serializable
data class LocationRestrictionDto(
        val circle: CircleDto
)

@Serializable
data class SearchNearbyRequest(
        val includedTypes: List<String>,
        val maxResultCount: Int,
        val languageCode: String,
        val locationRestriction: LocationRestrictionDto
)

@Serializable
data class DisplayNameDto(
        val text: String
)

@Serializable
data class PlaceDto(
        val id: String,
        val displayName: DisplayNameDto? = null,
        val location: LatLngDto? = null
)

@Serializable
data class SearchNearbyResponse(
        val places: List<PlaceDto> = emptyList()
)