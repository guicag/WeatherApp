package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import architecture.WeatherRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.WeatherRetrofit
import repository.WeatherRepository

class WeatherViewModel : ViewModel() {

    private val mWeatherRepository: WeatherRepository by lazy { WeatherRepository() }

    var mWeatherLiveData: LiveData<List<WeatherRetrofit>> = mWeatherRepository.selectAllWeather()

    fun fetchNewWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            mWeatherRepository.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mWeatherRepository.deleteAllWeather()
        }
    }
}
/*
private fun List<WeatherRetrofit>.toUi(): List<WeatherUI> {
    return asSequence().map {
        WeatherUI(
            temperature = it.temperature,
            wind = it.wind,
            description = it.description
        )
    }.toList()
}
*/
