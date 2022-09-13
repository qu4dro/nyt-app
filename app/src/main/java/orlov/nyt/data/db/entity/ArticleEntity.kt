package orlov.nyt.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    val caption: String,
    val byline: String,
    val photos: List<ArticlePhotoEntity>,
    val published_date: String,
    val section: String,
    val title: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val url: String
)

