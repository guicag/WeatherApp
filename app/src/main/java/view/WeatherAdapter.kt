package view

import android.app.ProgressDialog.show
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemWeatherBinding
import model.WeatherUI

val diffUtils = object : DiffUtil.ItemCallback<WeatherUI>() {
    override fun areItemsTheSame(oldItem: WeatherUI, newItem: WeatherUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherUI, newItem: WeatherUI): Boolean {
        return oldItem == newItem
    }
}

class WeatherAdapter() : ListAdapter<WeatherUI, WeatherViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class WeatherViewHolder(val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: WeatherUI

    fun bind(weatherUi: WeatherUI) {

        //var strTemp = weatherUi.temperature.replace("+", "").replace(" °C", "")
        ui = weatherUi
        binding.textCity.text = weatherUi.city
        binding.textWind.text = weatherUi.wind
        binding.textTemperature.text = weatherUi.temperature
        binding.textDescription.text = weatherUi.description
    }
}

