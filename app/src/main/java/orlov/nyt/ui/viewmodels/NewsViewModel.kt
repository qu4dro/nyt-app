package orlov.nyt.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import orlov.nyt.domain.usecase.news.NewsUseCases
import orlov.nyt.utils.Request
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel() {

    fun fetchTopNews() {
        viewModelScope.launch(Dispatchers.IO) {
            newsUseCases.fetchTopNewsUseCase.invoke().collect { request ->
                when (request) {
                    is Request.Error -> Timber.d(request.error.toString())
                    is Request.Loading -> Timber.d("Loading")
                    is Request.Success -> Timber.d(request.data.toString())
                }
            }
        }
    }

}