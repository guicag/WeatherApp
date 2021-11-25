package repository

import androidx.lifecycle.LiveData
import architecture.CustomApplication
import architecture.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.WeatherRetrofit

class WeatherRepository {
    private val mWeatherDao = CustomApplication.instance.mWeatherDatabase.myWeatherDao()

    fun selectAllWeather(): LiveData<List<WeatherRetrofit>> {
        return mWeatherDao.selectAll()
    }

    private suspend fun insertWeather(dataWeather: WeatherRetrofit) =
        withContext(Dispatchers.IO) {
            mWeatherDao.insert(dataWeather)
        }

    suspend fun deleteAllWeather() = withContext(Dispatchers.IO) {
        mWeatherDao.deleteAll()
    }

    suspend fun fetchData() {
        insertWeather(RetrofitBuilder.getWeather().getWeatherParis().toRoom())
    }
}
private fun WeatherRetrofit.toRoom(): WeatherRetrofit {
    return WeatherRetrofit(temperature = temperature, wind = wind, description = description)
}