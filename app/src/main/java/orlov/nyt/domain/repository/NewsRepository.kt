package orlov.nyt.domain.repository

import kotlinx.coroutines.flow.Flow
import orlov.nyt.domain.model.Article
import orlov.nyt.utils.Request

interface NewsRepository {

    suspend fun fetchTopNews(section: String): Flow<Request<List<Article>>>

}