package architecture

import com.google.gson.GsonBuilder
import remote.WeatherEndPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://goweather.herokuapp.com/weather/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()

    fun getWeather(): WeatherEndPoint = retrofit.create(WeatherEndPoint::class.java)
}