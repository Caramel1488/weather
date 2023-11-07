package com.test.weather.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class DayData(
    @SerializedName("maxtemp_c") val maxTemp: String,
    @SerializedName("mintemp_c") val minTemp: String,
    @SerializedName("maxwind_kph") val maxWind: String,
    @SerializedName("avghumidity") val humidity: String,
    @SerializedName("daily_chance_of_rain") val cloud: String
)
