package com.test.weather.detail

import com.test.weather.data.DayData
import com.test.weather.data.ForecastDayData
import com.test.weather.data.HourData

class DetailRepository {

    private var forecastDayData: ForecastDayData? = null

    fun putData(data: ForecastDayData) {
        forecastDayData = data
    }

    fun getDayData(): ForecastDayData {
        return forecastDayData!!
    }

    fun getHourList(): List<HourData>{
        return forecastDayData!!.hour
    }
}