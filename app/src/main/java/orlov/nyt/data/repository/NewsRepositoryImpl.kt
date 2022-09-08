package orlov.nyt.data.repository

import kotlinx.coroutines.flow.Flow
import orlov.nyt.data.mapper.mapToDomain
import orlov.nyt.data.network.service.NewsService
import orlov.nyt.domain.model.Article
import orlov.nyt.domain.repository.NewsRepository
import orlov.nyt.utils.Request
import orlov.nyt.utils.RequestUtils
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : NewsRepository {

    override suspend fun fetchTopNews(): Flow<Request<List<Article>>> {
        return RequestUtils.requestFlow {
            val response = newsService.fetchTopNews()
            val news = response.results.map { it.mapToDomain() }
            news
        }
    }

}