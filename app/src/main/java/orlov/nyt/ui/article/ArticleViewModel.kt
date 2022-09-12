package orlov.nyt.ui.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import orlov.nyt.domain.model.Article
import orlov.nyt.domain.usecase.news.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel() {

    private var _selectedArticles = newsUseCases.fetchSavedNewsUseCase.invoke()
    val selectedArticles
        get() = _selectedArticles

    fun saveArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        newsUseCases.saveArticleUseCase.invoke(article)
    }

    fun deleteArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        newsUseCases.deleteArticleUseCase.invoke(article)
    }

}