package orlov.nyt.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import orlov.nyt.data.db.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], exportSchema = false, version = 1)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

    companion object {

        private const val DATABASE_NAME = "news_db.db"

        @Volatile
        private var instance: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): NewsDatabase {
            val database =
                Room.databaseBuilder(context, NewsDatabase::class.java, DATABASE_NAME)
                    .addCallback(object : RoomDatabase.Callback() {})
                    .build()

            return database
        }

    }

}