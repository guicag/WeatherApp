package view

import android.app.ProgressDialog.show
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
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

        var strTemp = weatherUi.temperature.replace("+", "").replace(" °C", "").toInt()
        when (strTemp) {
            in -100 .. 5 -> Glide.with(itemView.context)
                .load("https://images.emojiterra.com/openmoji/v13.1/512px/2744.png")
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageWeather)
            in 5 .. 20    -> Glide.with(itemView.context)
                .load("https://cdn-0.emojis.wiki/emoji-pics/microsoft/cloud-microsoft.png")
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageWeather)
            else -> Glide.with(itemView.context)
                .load("https://cdn.emojidex.com/emoji/seal/white_sun_with_rays.png?1422536271")
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageWeather)
        }
        ui = weatherUi
        binding.textCity.text = weatherUi.city
        binding.textWind.text = weatherUi.wind
        binding.textTemperature.text = weatherUi.temperature
        binding.textDescription.text = weatherUi.description
    }
}

