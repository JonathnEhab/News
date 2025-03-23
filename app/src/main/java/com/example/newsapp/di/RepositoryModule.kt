package com.example.newsapp.di

import com.example.newsapp.core.local.NewsDao
import com.example.newsapp.core.remote.api.ApiService
import com.example.newsapp.presenter.ui.repository.NewsRepositoryImpl
import com.example.newsapp.presenter.ui.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        apiService: ApiService,
        newsDao: NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(apiService, newsDao)
    }
}
