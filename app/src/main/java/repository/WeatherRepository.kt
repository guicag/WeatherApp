package repository

import androidx.lifecycle.LiveData
import architecture.CustomApplication
import architecture.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.DataWeather
import model.WeatherRetrofit

class WeatherRepository {
    private val mWeatherDao = CustomApplication.instance.mWeatherDatabase.myWeatherDao()

    fun selectAllWeather(): LiveData<List<DataWeather>> {
        return mWeatherDao.selectAll()
    }

    private suspend fun insertWeatherWithForecast(dataWeatherWithForecast: DataWeather) =
        withContext(Dispatchers.IO) {
            mWeatherDao.insert(dataWeatherWithForecast)
        }

    suspend fun deleteAllWeather() = withContext(Dispatchers.IO) {
        mWeatherDao.deleteAll()
    }

    suspend fun fetchData() {
        insertWeatherWithForecast(RetrofitBuilder.getWeather().getWeatherParis().toRoom())
    }
}
private fun WeatherRetrofit.toRoom(): DataWeather {
    return DataWeather(description = description, wind = wind, temperature = temperature, forecastDetails = forecastRetrofit)
}