package orlov.nyt.domain.usecase.news

import orlov.nyt.domain.repository.NewsRepository
import javax.inject.Inject

class FetchSavedNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke() = newsRepository.fetchSavedNews()

}
