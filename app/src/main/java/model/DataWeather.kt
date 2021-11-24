package model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/** Object use for UI **/
data class WeatherUI(
    val temperature:String,
    val wind:String,
    val description:String
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
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

