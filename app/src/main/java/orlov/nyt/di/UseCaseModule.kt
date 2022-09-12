package orlov.nyt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orlov.nyt.data.repository.NewsRepositoryImpl
import orlov.nyt.domain.usecase.news.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideFetchTopNewsUseCase(newsRepository: NewsRepositoryImpl) =
        FetchTopNewsUseCase(newsRepository)

    @Provides
    @Singleton
    fun provideFetchSavedNewsUseCase(newsRepository: NewsRepositoryImpl) =
        FetchSavedNewsUseCase(newsRepository)

    @Provides
    @Singleton
    fun provideSaveArticleUseCase(newsRepository: NewsRepositoryImpl) =
        SaveArticleUseCase(newsRepository)


    @Provides
    @Singleton
    fun provideDeleteArticleUseCase(newsRepository: NewsRepositoryImpl) =
        DeleteArticleUseCase(newsRepository)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        fetchTopNewsUseCase: FetchTopNewsUseCase,
        fetchSavedNewsUseCase: FetchSavedNewsUseCase,
        saveArticleUseCase: SaveArticleUseCase,
        deleteArticleUseCase: DeleteArticleUseCase
    ) =
        NewsUseCases(
            fetchTopNewsUseCase,
            fetchSavedNewsUseCase,
            saveArticleUseCase,
            deleteArticleUseCase
        )

}