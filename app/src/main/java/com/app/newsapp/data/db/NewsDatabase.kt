package com.app.newsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.newsapp.data.db.entity.NewsArticleEntity

@Database(entities = [NewsArticleEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}