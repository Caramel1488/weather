package com.test.weather.detail

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skillbox.github.utils.autoCleared
import com.test.weather.R
import com.test.weather.data.DayData
import com.test.weather.data.ForecastDayData

class DetailDayFragment(): Fragment(R.layout.fragment_detail_day){

    private val args: DetailDayFragmentArgs by navArgs()

    private val viewModel : DetailViewModel by viewModels()

    private var hourListAdapter: HourListAdapter by autoCleared()

    private lateinit var hourList: RecyclerView

    //private var dayListAdapter: DayListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initAdapter()
        viewModel.getData()
        observe()
    }

    private fun observe() {
        viewModel.dayData.observe(viewLifecycleOwner){
            setData(it)
        }
        viewModel.hourList.observe(viewLifecycleOwner){
            hourListAdapter.submitList(it)
        }
    }

    private fun setData(dayData: ForecastDayData) {
        with(requireView()){
            findViewById<TextView>(R.id.dateTextView).text = dayData.date
            findViewById<TextView>(R.id.cloudTextView).text = dayData.day.cloud + " %"
            findViewById<TextView>(R.id.humidityTextView).text = dayData.day.humidity + " %"
            findViewById<TextView>(R.id.windTextView).text = dayData.day.maxWind + " kph"
            findViewById<TextView>(R.id.temperatureTextView).text = "${dayData.day.maxTemp} C° / ${dayData.day.minTemp} C°"
        }
    }

    private fun initData() {
        viewModel.putData(args.forecastDay!!)
    }

    fun initAdapter(){
        hourListAdapter = HourListAdapter()
        hourList = requireView().findViewById(R.id.hourList)
        with(hourList){
            adapter = hourListAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(DividerItemDecoration(context, LinearLayout.HORIZONTAL))
            //setHasFixedSize(true)
        }
    }
}