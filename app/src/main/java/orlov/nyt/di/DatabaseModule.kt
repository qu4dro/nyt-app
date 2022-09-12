package orlov.nyt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import orlov.nyt.data.db.NewsDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context) =
        NewsDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideNewsDao(db: NewsDatabase) = db.getNewsDao()

}