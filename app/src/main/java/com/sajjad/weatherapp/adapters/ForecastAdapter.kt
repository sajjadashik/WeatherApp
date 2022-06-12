package com.sajjad.weatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sajjad.weatherapp.databinding.ForecastItemRowBinding
import com.sajjad.weatherapp.models.ForecastModel


class ForecastAdapter : ListAdapter<ForecastModel.ForecastItem, ForecastAdapter.ForecastViewHolder>(ForecastDiffUtil()){

    class ForecastViewHolder(val binding: ForecastItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ForecastModel.ForecastItem) {
            binding.item = item
        }
    }

    class ForecastDiffUtil : DiffUtil.ItemCallback<ForecastModel.ForecastItem>() {
        override fun areItemsTheSame(
            oldItem: ForecastModel.ForecastItem,
            newItem: ForecastModel.ForecastItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ForecastModel.ForecastItem,
            newItem: ForecastModel.ForecastItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val binding = ForecastItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}