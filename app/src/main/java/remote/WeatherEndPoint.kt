package remote

import model.WeatherRetrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherEndPoint {

    @GET("{city}")
    suspend fun getWeatherCity(@Path("city") city: String) : WeatherRetrofit

}