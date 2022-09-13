package orlov.nyt.ui.bookmarks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import orlov.nyt.domain.usecase.news.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel() {

    private val _uiState = MutableStateFlow(BookmarksUiState())
    val uiState
        get() = _uiState

    init {
        fetchSavedNews()
    }

    private fun fetchSavedNews() =
        viewModelScope.launch {
            newsUseCases.fetchSavedNewsUseCase.invoke().collect { articleLists ->
                _uiState.update { it.copy(articleItems = articleLists, isEmpty = articleLists.isEmpty()) }
            }
        }
}