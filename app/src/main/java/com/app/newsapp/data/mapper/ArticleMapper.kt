package com.app.newsapp.data.mapper

import com.app.newsapp.api.NewsArticle
import com.app.newsapp.data.db.entity.NewsArticleEntity

fun List<NewsArticle>.toNewsEntityList(): List<NewsArticleEntity> {
    return map {
        NewsArticleEntity(
            author = it.author,
            title = it.title,
            description = it.description,
            url = it.url,
            urlToImage = it.urlToImage,
            publishedAt = it.publishedAt,
            content = it.content
        )
    }
}