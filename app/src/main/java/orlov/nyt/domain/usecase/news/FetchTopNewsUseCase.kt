package orlov.nyt.domain.usecase.news

import orlov.nyt.domain.repository.NewsRepository
import javax.inject.Inject

class FetchTopNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(section: String) = newsRepository.fetchTopNews(section)

}