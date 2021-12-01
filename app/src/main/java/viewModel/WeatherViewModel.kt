package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.DataWeather
import model.WeatherUI
import repository.WeatherRepository

class WeatherViewModel : ViewModel() {

    private val mWeatherRepository: WeatherRepository by lazy { WeatherRepository() }

    var mWeatherLiveData: LiveData<List<WeatherUI>> =
        mWeatherRepository.selectAllWeather().map {
            it.toUi()
        }

    fun fetchNewWeather(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mWeatherRepository.fetchData(city)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mWeatherRepository.deleteAllWeather()
        }
    }
}

private fun List<DataWeather>.toUi(): List<WeatherUI> {
    return asSequence().map {
        WeatherUI(
            city = it.city,
            temperature = it.temperature,
            wind = it.wind,
            description = it.description,
        )
    }.toList()
}
