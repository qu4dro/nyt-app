package orlov.nyt.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import orlov.nyt.data.db.NewsDao
import orlov.nyt.data.mapper.mapToDomain
import orlov.nyt.data.mapper.mapToEntity
import orlov.nyt.data.network.service.NewsService
import orlov.nyt.domain.model.Article
import orlov.nyt.domain.repository.NewsRepository
import orlov.nyt.utils.Request
import orlov.nyt.utils.RequestUtils
import timber.log.Timber
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun fetchTopNews(section: String): Flow<Request<List<Article>>> {
        return RequestUtils.requestFlow {
            val response = newsService.fetchTopNews(section)
            val news = response.results
            news.map { it.mapToDomain() }
        }
    }

    override suspend fun saveArticle(article: Article) {
       newsDao.insertArticle(article.mapToEntity())
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.deleteArticle(article.mapToEntity())
    }

    override suspend fun searchNews(searchQuery: String): Flow<Request<List<Article>>> {
        return RequestUtils.requestFlow {
            try {
                val response = newsService.searchNews(searchQuery)
                val news = response.results.docs
                news.map { it.mapToDomain() }
            } catch (e: Exception) {
                Timber.d(e.message.toString())
                listOf()
            }
        }
    }

    override fun fetchSavedNews(): Flow<List<Article>> {
        val articles = newsDao.fetchSavedNews()
        return articles.map { list -> list.map { it.mapToDomain() } }
    }


}