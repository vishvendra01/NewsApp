package com.app.newsapp.data.repo

import com.app.newsapp.api.NewsApi
import com.app.newsapp.data.db.NewsDao
import com.app.newsapp.data.db.entity.NewsArticleEntity
import com.app.newsapp.data.mapper.toNewsEntityList
import com.app.newsapp.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(val newsApi: NewsApi, val newsDao: NewsDao) :
    NewsRepository {

    override fun getTopHeadlines(): Flow<State<List<NewsArticleEntity>>> = flow {
        emit(State.loading<List<NewsArticleEntity>>())

        val newsArticles = try {
            newsApi.getTopHeadlines().body()?.articles?.toNewsEntityList() ?: emptyList()
        } catch (ex: Exception) {
            emptyList()
        }

        if (newsArticles.isNotEmpty()) newsDao.deleteAndInsertArticles(newsArticles)

        val cachedArticles = newsDao.getNewsArticles()
        emitAll(cachedArticles.map { State.success(it) })
    }.flowOn(Dispatchers.IO)
}