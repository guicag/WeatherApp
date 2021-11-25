package remote

import model.WeatherRetrofit
import retrofit2.http.GET

interface WeatherEndPoint {

    @GET("London")
    suspend fun getWeatherParis() : WeatherRetrofit

}