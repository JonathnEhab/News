package com.example.newsapp.presenter.ui.repository

import com.example.newsapp.domain.news.NewsModel

interface NewsRepository {
    suspend fun getNews(query: String, apiKey: String): NewsModel
    suspend fun getOfflineNews(): NewsModel
}