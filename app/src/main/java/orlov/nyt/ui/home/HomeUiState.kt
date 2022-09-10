package orlov.nyt.ui.home

import orlov.nyt.domain.model.Article

data class HomeUiState(
    val loadState: LoadState = LoadState.SUCCESS,
    val articleItems: List<Article> = listOf(),
    val sections: List<String> = sectionsList,
    val selectedSection: String = sections[0]
)

// временная заглушка для секций
val sectionsList = listOf<String>(
    "home",
    "arts",
    "automobiles",
    "books",
    "business",
    "fashion",
    "food",
    "health",
    "insider",
    "magazine",
    "movies",
    "nyregion",
    "obituaries",
    "opinion",
    "politics",
    "realestate",
    "science",
    "sports",
    "sundayreview",
    "technology",
    "theater",
    "t-magazine",
    "travel",
    "upshot",
    "us",
    "world"
)

enum class LoadState {
    LOADING,
    ERROR,
    SUCCESS
}