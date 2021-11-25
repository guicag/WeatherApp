package architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dao.WeatherDao
import model.WeatherRetrofit

@TypeConverters(Converters::class)
@Database(
    entities = [
        WeatherRetrofit::class
    ],
    version = 2,
    exportSchema = false
)

abstract class WeatherRoomDatabase : RoomDatabase() {
    abstract fun myWeatherDao() : WeatherDao
}