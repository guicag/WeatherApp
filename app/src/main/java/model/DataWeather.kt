package model

import androidx.room.*


/** Object use for UI **/
data class WeatherUI(
    val city:String,
    val temperature:String,
    val wind:String,
    val description:String,
)

/** Object use for room */
@Entity(tableName = "weather")
data class DataWeather(

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "temperature")
    val temperature: String,

    @ColumnInfo(name = "wind")
    val wind: String,

    @ColumnInfo(name = "description")
    val description: String,


) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

