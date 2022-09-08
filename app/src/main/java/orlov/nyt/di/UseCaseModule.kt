package orlov.nyt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import orlov.nyt.data.repository.NewsRepositoryImpl
import orlov.nyt.domain.usecase.news.FetchTopNewsUseCase
import orlov.nyt.domain.usecase.news.NewsUseCases
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
    fun provideNewsUseCases(fetchTopNewsUseCase: FetchTopNewsUseCase) =
        NewsUseCases(fetchTopNewsUseCase)

}