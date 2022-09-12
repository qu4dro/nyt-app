package orlov.nyt.domain.usecase.news

data class NewsUseCases(
    val fetchTopNewsUseCase: FetchTopNewsUseCase,
    val fetchSavedNewsUseCase: FetchSavedNewsUseCase,
    val saveArticleUseCase: SaveArticleUseCase
)
