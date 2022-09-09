package orlov.nyt.ui.home

import orlov.nyt.domain.model.Article

data class HomeUiState(
    val loadState: LoadState = LoadState.SUCCESS,
    val articleItems: List<Article> = listOf()
)

enum class LoadState {
    LOADING,
    ERROR,
    SUCCESS
}