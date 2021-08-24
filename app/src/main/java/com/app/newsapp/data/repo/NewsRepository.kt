package com.app.newsapp.data.repo

import com.app.newsapp.data.db.entity.NewsArticleEntity
import com.app.newsapp.utils.State
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getTopHeadlines(): Flow<State<List<NewsArticleEntity>>>
}