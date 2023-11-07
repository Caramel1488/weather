package com.test.weather.data

import com.google.gson.annotations.SerializedName
import com.test.weather.data.LocationData
import com.test.weather.data.CurrentWeatherData
import com.test.weather.data.ForecastData
import kotlinx.serialization.Serializable

@Serializable
data class WeatherSearchResponse(
    @SerializedName("location") val location: LocationData,
    @SerializedName("current") val currentWeatherData: CurrentWeatherData,
    @SerializedName("forecast") val forecastData: ForecastData
)
