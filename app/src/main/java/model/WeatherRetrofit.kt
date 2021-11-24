package model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherRetrofit(
    @Expose
    @SerializedName("temperature")
    val temperature: String,

    @Expose
    @SerializedName("wind")
    val wind: String,

    @Expose
    @SerializedName("description")
    val description: String
)
