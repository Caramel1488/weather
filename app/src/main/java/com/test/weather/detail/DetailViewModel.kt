package com.test.weather.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.weather.data.DayData
import com.test.weather.data.ForecastDayData
import com.test.weather.data.HourData

class DetailViewModel(): ViewModel() {

    private val repository = DetailRepository()

    private val dayDataLiveData = MutableLiveData<ForecastDayData>()
    private val hourListLiveData = MutableLiveData<List<HourData>>()

    val hourList: LiveData<List<HourData>>
        get() = hourListLiveData

    val dayData: LiveData<ForecastDayData>
        get() = dayDataLiveData

    fun putData(data: ForecastDayData){
        repository.putData(data)
    }

    fun getData(){
        dayDataLiveData.postValue(repository.getDayData())
        hourListLiveData.postValue(repository.getHourList())
    }
}