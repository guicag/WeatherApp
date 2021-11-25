package dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import model.WeatherRetrofit

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather")
    fun selectAll() : LiveData<List<WeatherRetrofit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dataWeather: WeatherRetrofit)

    @Query("DELETE FROM weather")
    fun deleteAll()
}