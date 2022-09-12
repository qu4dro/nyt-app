package orlov.nyt.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.flow.Flow
import orlov.nyt.data.db.NewsDao
import orlov.nyt.data.mapper.mapToDomain
import orlov.nyt.data.mapper.mapToEntity
import orlov.nyt.data.network.service.NewsService
import orlov.nyt.domain.model.Article
import orlov.nyt.domain.repository.NewsRepository
import orlov.nyt.utils.Request
import orlov.nyt.utils.RequestUtils
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

    override fun fetchSavedNews(): LiveData<List<Article>> {
        return Transformations.map(newsDao.fetchSavedNews()) { articles -> articles.map { it.mapToDomain() }}
    }


}