package model

import androidx.room.*


/** Object use for UI **/
data class WeatherUI(
    val temperature:String,
    val wind:String,
    val description:String,
    val forecastDetails: List<DataForecastDetail>
)

/** Object use for room */
@Entity(tableName = "weather")
data class DataWeather(

    @ColumnInfo(name = "temperature")
    val temperature: String,

    @ColumnInfo(name = "wind")
    val wind: String,

    @ColumnInfo(name = "description")
    val description: String,

    @Embedded()
    val forecastDetails: List<DataForecastDetail>

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

data class DataForecastDetail(

    @ColumnInfo(name = "detail_day")
    val detail_day: String,

    @ColumnInfo(name = "detail_temperature")
    val detail_temperature: String,

    @ColumnInfo(name = "detail_wind")
    val detail_wind: String

)