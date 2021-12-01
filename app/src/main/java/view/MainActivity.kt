package view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import model.WeatherUI
import viewModel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel
    private lateinit var binding : ActivityMainBinding
    private val adapter : WeatherAdapter = WeatherAdapter()
    private val observer = Observer<List<WeatherUI>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = adapter

        val spinner: Spinner = findViewById(R.id.cities_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.cities_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        binding.buttonAddWeather.setOnClickListener {
            viewModel.fetchNewWeather(spinner.selectedItem.toString())
        }

        binding.buttonDeleteWeather.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.mWeatherLiveData
        viewModel.mWeatherLiveData.observe(this, observer)
    }

    override fun onStop() {
        viewModel.mWeatherLiveData.removeObserver(observer)
        super.onStop()
    }
}
