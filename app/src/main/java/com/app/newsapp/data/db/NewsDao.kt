package com.app.newsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.app.newsapp.api.NewsArticle
import com.app.newsapp.data.db.entity.NewsArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert
    fun insert(articles: List<NewsArticleEntity>)

    @Query("DELETE FROM news_article")
    fun deleteAllArticles()

    @Transaction
    fun deleteAndInsertArticles(articles: List<NewsArticleEntity>) {
        deleteAllArticles()
        insert(articles)
    }

    @Query("SELECT * from news_article")
    fun getNewsArticles(): Flow<List<NewsArticleEntity>>
}