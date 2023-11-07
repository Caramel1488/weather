package com.test.weather.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.weather.data.ForecastDayData
import com.test.weather.data.WeatherSearchResponse
import kotlinx.coroutines.launch

class MainViewModel(application: Application):AndroidViewModel(application) {
    private val repository = MainRepository(application)

    private val weatherLiveData = MutableLiveData<WeatherSearchResponse>()
    private val locationLiveData = MutableLiveData<String>()
    private val forecastLiveData = MutableLiveData<List<ForecastDayData>>(emptyList())

    val weather : LiveData<WeatherSearchResponse>
        get() = weatherLiveData
    val location : LiveData<String>
        get() = locationLiveData
    val forecast : LiveData<List<ForecastDayData>>
        get() = forecastLiveData

    fun getCurrentWeather(q:String){
        viewModelScope.launch {
            try {
                val response = repository.getForecast(q)
                locationLiveData.postValue(response.location.name)
                forecastLiveData.postValue(response.forecastData.forecastDay)
            }catch (t:Throwable){
                Log.d("Response", t.message.toString())
            }
        }
    }
}