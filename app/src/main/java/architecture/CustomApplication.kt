package architecture

import android.app.Application
import androidx.room.Room

class CustomApplication : Application() {

    companion object {
        lateinit var instance: CustomApplication
    }

    val mWeatherDatabase: WeatherRoomDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            WeatherRoomDatabase::class.java,
            "weather"
        ).fallbackToDestructiveMigration().build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
