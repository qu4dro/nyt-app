package orlov.nyt.data.mapper

import orlov.nyt.data.db.entity.ArticleEntity
import orlov.nyt.data.db.entity.ArticlePhotoEntity
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

fun Article.mapToEntity(): ArticleEntity {
    return ArticleEntity(
        this.abstract,
        this.byline,
        this.photos.map { it.mapToEntity() },
        this.published_date,
        this.section,
        this.title,
        this.id,
        this.url
    )
}

fun ArticleEntity.mapToDomain(): Article {
    return Article(
        this.abstract,
        this.byline,
        this.photos.map { it.mapToDomain() },
        this.published_date,
        this.section,
        this.title,
        this.id,
        this.url
    )
}

fun ArticlePhoto.mapToEntity(): ArticlePhotoEntity {
    return ArticlePhotoEntity(
        this.caption,
        this.url
    )
}

fun ArticlePhotoEntity.mapToDomain(): ArticlePhoto {
    return ArticlePhoto(
        this.caption,
        this.url
    )
}