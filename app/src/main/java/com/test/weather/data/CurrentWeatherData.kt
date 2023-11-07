package com.test.weather.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherData(
    @SerializedName("temp_c") val temperature: String
)