package com.example.newsapp.presenter.ui.repository


import com.example.newsapp.core.local.NewsDao
import com.example.newsapp.core.remote.api.ApiService
import com.example.newsapp.domain.news.NewsModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val newsDao: NewsDao
) : NewsRepository {

    private val _newsData = MutableStateFlow<NewsModel?>(null)

    override suspend fun getNews(query: String, apiKey: String): NewsModel {
        val response = apiService.getNews(query, apiKey)
        _newsData.value = response
        newsDao.insertAll(response)
        return response
    }

    override suspend fun getOfflineNews(): NewsModel {
        return newsDao.getAllArticles()
    }
}

