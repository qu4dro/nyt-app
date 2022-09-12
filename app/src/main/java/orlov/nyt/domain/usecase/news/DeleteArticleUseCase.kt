package orlov.nyt.domain.usecase.news

import orlov.nyt.domain.model.Article
import orlov.nyt.domain.repository.NewsRepository
import javax.inject.Inject

class DeleteArticleUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(article: Article) = newsRepository.deleteArticle(article)

}