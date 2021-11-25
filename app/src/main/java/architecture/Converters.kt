package architecture

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromStringToArrayListString(listOfString: String): List<String> =
        Gson().fromJson(listOfString, object : TypeToken<ArrayList<String>>() {}.type)


    @TypeConverter
    fun fromArrayListStringToString(listOfString: List<String>): String =
        Gson().toJson(listOfString)

}