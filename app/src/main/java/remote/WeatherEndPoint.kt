package remote

import model.WeatherRetrofit
import retrofit2.http.GET

interface WeatherEndPoint {

    @GET("Paris")
    suspend fun getWeatherParis() : WeatherRetrofit

}