package com.test.weather.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

@kotlinx.serialization.Serializable
data class ForecastDayData(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: DayData,
    @SerializedName("hour") val hour : List<HourData>
): Serializable