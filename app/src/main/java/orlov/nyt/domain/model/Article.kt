package orlov.nyt.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val abstract: String,
    val byline: String,
    val photos: List<ArticlePhoto>,
    val published_date: String,
    val section: String,
    val title: String,
    val id: String,
    val url: String,
) : Parcelable