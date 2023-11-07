package com.test.weather.detail

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skillbox.github.utils.inflate
import com.test.weather.R
import com.test.weather.data.HourData

class HourListAdapter(): ListAdapter<HourData, HourListAdapter.Holder>(RepoDiffUtilCallback()) {

    class RepoDiffUtilCallback : DiffUtil.ItemCallback<HourData>() {
        override fun areItemsTheSame(oldItem: HourData, newItem: HourData): Boolean {
            return oldItem.time == newItem.time
        }

        override fun areContentsTheSame(
            oldItem: HourData,
            newItem: HourData
        ): Boolean {
            return oldItem == newItem
        }

    }

    class Holder(
        private val containerView: View,
    ) : RecyclerView.ViewHolder(containerView) {

        fun bind(hour: HourData) {
            containerView.findViewById<TextView>(R.id.hourTextView).text = hour.time.takeLast(5)
            containerView.findViewById<TextView>(R.id.temperatureTextView).text =
                "${hour.temperature} C°"
            containerView.findViewById<TextView>(R.id.windTextView).text =
                hour.wind + " kph"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.item_hour_list))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}