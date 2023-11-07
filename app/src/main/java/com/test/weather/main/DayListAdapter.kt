package com.test.weather.main

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skillbox.github.utils.inflate
import com.test.weather.R
import com.test.weather.data.ForecastDayData

class DayListAdapter(
    private val onItemClick: (position: Int) -> Unit
) : ListAdapter<ForecastDayData, DayListAdapter.Holder>(RepoDiffUtilCallback()) {

    class RepoDiffUtilCallback : DiffUtil.ItemCallback<ForecastDayData>() {
        override fun areItemsTheSame(oldItem: ForecastDayData, newItem: ForecastDayData): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(
            oldItem: ForecastDayData,
            newItem: ForecastDayData
        ): Boolean {
            return oldItem == newItem
        }

    }

    class Holder(
        private val containerView: View,
        val onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(containerView) {

        init {
            containerView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(day: ForecastDayData) {
            containerView.findViewById<TextView>(R.id.dateTextView).text = day.date
            containerView.findViewById<TextView>(R.id.cloudTextView).text = day.day.cloud + " %"
            containerView.findViewById<TextView>(R.id.humidityTextView).text =
                day.day.humidity + " %"
            containerView.findViewById<TextView>(R.id.windTextView).text =
                day.day.maxWind + " kph"
            containerView.findViewById<TextView>(R.id.temperatureTextView).text =
                "${day.day.maxTemp} C° / ${day.day.minTemp} C°"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.item_main_list), onItemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

}