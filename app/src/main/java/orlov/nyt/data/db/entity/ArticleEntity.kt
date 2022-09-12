package orlov.nyt.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    var abstract: String,
    var byline: String,
    var photos: List<ArticlePhotoEntity>,
    var published_date: String,
    var section: String,
    var title: String,
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var url: String
) {
    constructor() : this("", "", listOf(), "", "", "", "", "")
}
