package com.app.newsapp.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "news_article")
data class NewsArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "author")
    val author: String? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "url")
    val url: String? = null,

    @ColumnInfo(name = "urlToImage")
    val urlToImage: String? = null,

    @ColumnInfo(name = "publishedAt")
    val publishedAt: String? = null,

    @ColumnInfo(name = "content")
    val content: String? = null
) : Parcelable