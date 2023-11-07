package com.test.weather.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LocationData(
    @SerializedName("name") val name: String,
    @SerializedName("lat") val latitude: String,
    @SerializedName("lon") val longitude: String,
)