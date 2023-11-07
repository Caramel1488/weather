package com.test.weather.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastData(
    @SerializedName("forecastday") val forecastDay: List<ForecastDayData>
)
