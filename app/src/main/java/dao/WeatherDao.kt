package dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import model.DataWeather

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather")
    fun selectAll() : LiveData<List<DataWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dataWeather: DataWeather)

    @Query("DELETE FROM weather")
    fun deleteAll()
}