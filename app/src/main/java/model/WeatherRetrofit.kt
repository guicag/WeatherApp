package model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather")
data class WeatherRetrofit(
    @Expose
    @SerializedName("temperature")
    val temperature: String,

    @Expose
    @SerializedName("wind")
    val wind: String,

    @Expose
    @SerializedName("description")
    val description: String,

    @Expose
    @SerializedName("forecast")
    val forecastDetails: List<ForecastDetail>
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


data class ForecastDetail(
    @Expose
    @SerializedName("day")
    val day: String,

    @Expose
    @SerializedName("temperature")
    val temperature: String,

    @Expose
    @SerializedName("wind")
    val wind: String
)