package com.test.weather.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherSearchResponse(
    @SerializedName("location") val location: LocationData,
    @SerializedName("forecast") val forecastData: ForecastData
)
