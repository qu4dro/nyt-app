package orlov.nyt.domain.usecase.news

import orlov.nyt.domain.repository.NewsRepository
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(searchQuery: String) = newsRepository.searchNews(searchQuery)

}