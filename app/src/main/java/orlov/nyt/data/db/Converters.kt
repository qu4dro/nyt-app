package orlov.nyt.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import orlov.nyt.data.db.entity.ArticlePhotoEntity

class Converters {

    @TypeConverter
    fun photosToString(photos: List<ArticlePhotoEntity>): String = Gson().toJson(photos)

    @TypeConverter
    fun stringToPhotos(photoString: String): List<ArticlePhotoEntity> {
        val listType = object : TypeToken<List<ArticlePhotoEntity?>?>() {}.type
        return Gson().fromJson(photoString, listType)
    }


}