package com.test.weather.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class HourData(
    @SerializedName("time") val time: String,
    @SerializedName("temp_c") val temperature: String,
    @SerializedName("wind_kph") val wind: String,
)
