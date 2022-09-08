package orlov.nyt.domain.model

data class Article(
    val abstract: String,
    val byline: String,
    val photos: List<ArticlePhoto>,
    val published_date: String,
    val section: String,
    val title: String,
    val uri: String,
    val url: String
)