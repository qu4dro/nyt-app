package orlov.nyt.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import orlov.nyt.domain.usecase.news.NewsUseCases
import orlov.nyt.utils.LoadState
import orlov.nyt.utils.Request
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState
        get() = _uiState.asStateFlow()

    private var searchJob: Job? = null

    fun searchNews(searchQuery: String) {
//        searchJob?.cancel()
//        searchJob = viewModelScope.launch(Dispatchers.IO) {
//            delay(1000L)
//            newsUseCases.searchNewsUseCase.invoke(searchQuery).collect { request ->
//                when (request) {
//                    is Request.Error -> {
//                        _uiState.update { it.copy(loadState = LoadState.ERROR) }
//                    }
//                    is Request.Loading -> {
//                        _uiState.update { it.copy(loadState = LoadState.LOADING) }
//                    }
//                    is Request.Success -> {
//                        val articles = request.data ?: listOf()
//                        _uiState.update {
//                            it.copy(
//                                loadState = LoadState.SUCCESS,
//                                articleItems = articles
//                            )
//                        }
//                    }
//                }
//            }
//
//        }
    }

}