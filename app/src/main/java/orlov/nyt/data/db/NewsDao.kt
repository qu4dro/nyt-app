package orlov.nyt.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import orlov.nyt.data.db.entity.ArticleEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM articles")
    fun fetchSavedNews(): LiveData<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articles: List<ArticleEntity>)

    @Delete
    suspend fun deleteArticle(article: ArticleEntity)

    @Query("SELECT * FROM articles WHERE id = :id LIMIT 1")
    fun fetchArticle(id: String): ArticleEntity

}