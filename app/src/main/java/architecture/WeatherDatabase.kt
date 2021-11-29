package architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import dao.WeatherDao
import model.DataWeather

@Database(
    entities = [
        DataWeather::class
    ],
    version = 2,
    exportSchema = false
)

abstract class WeatherRoomDatabase : RoomDatabase() {
    abstract fun myWeatherDao() : WeatherDao
}