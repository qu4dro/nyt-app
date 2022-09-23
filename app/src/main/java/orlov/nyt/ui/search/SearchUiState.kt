package orlov.nyt.ui.search

import orlov.nyt.domain.model.Article
import orlov.nyt.utils.LoadState

data class SearchUiState(
    val loadState: LoadState = LoadState.SUCCESS,
    val articleItems: List<Article> = listOf(),
    val searchState: SearchState = SearchState.EMPTY
)

enum class SearchState {
    EMPTY,
    NOT_EMPTY
}