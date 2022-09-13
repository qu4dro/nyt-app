package orlov.nyt.ui.bookmarks

import orlov.nyt.domain.model.Article

data class BookmarksUiState(
    val articleItems: List<Article> = listOf(),
    val isEmpty: Boolean = true
)