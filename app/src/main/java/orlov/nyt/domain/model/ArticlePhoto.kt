package orlov.nyt.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlePhoto(
    val caption: String,
    val url: String,
) : Parcelable
