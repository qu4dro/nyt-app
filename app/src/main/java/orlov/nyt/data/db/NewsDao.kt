package orlov.nyt.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import orlov.nyt.data.db.entity.ArticleEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM articles ORDER BY published_date")
    fun fetchSavedNews(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<ArticleEntity>)

    @Delete
    suspend fun deleteArticle(article: ArticleEntity)

    @Query("SELECT * FROM articles WHERE id = :id LIMIT 1")
    fun fetchArticle(id: String): ArticleEntity

}