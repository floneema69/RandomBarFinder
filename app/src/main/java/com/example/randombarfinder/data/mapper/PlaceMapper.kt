package com.example.randombarfinder.data.mapper

import com.example.randombarfinder.data.remote.dto.PlaceDto
import com.example.randombarfinder.data.remote.dto.SearchNearbyResponse
import com.example.randombarfinder.model.Bar

fun PlaceDto.toBar(): Bar? {
    val location = this.location ?: return null
    return Bar(
        id = this.id,
        name = this.displayName?.text ?: "Bar sans nom",
        latitude = location.latitude,
        longitude = location.longitude,

        )
}

fun SearchNearbyResponse.toBars(): List<Bar> {
    return this.places.mapNotNull { it.toBar() }
}