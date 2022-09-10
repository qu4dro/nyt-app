package orlov.nyt.data.mapper

import orlov.nyt.data.network.model.Multimedia
import orlov.nyt.data.network.model.Result
import orlov.nyt.domain.model.Article
import orlov.nyt.domain.model.ArticlePhoto

fun Result.mapToDomain(): Article {
    return Article(
        this.abstract,
        this.byline,
        this.multimedia?.map { it.mapToDomain() } ?: listOf<ArticlePhoto>(
            ArticlePhoto("", ""),
            ArticlePhoto("", ""),
            ArticlePhoto("", "")
        ),
        this.published_date,
        this.subsection,
        this.title,
        this.uri,
        this.url
    )
}

fun Multimedia.mapToDomain(): ArticlePhoto {
    return ArticlePhoto(
        this.caption,
        this.url
    )
}