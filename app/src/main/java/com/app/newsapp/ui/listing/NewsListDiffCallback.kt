package com.app.newsapp.ui.listing

import androidx.recyclerview.widget.DiffUtil
import com.app.newsapp.data.db.entity.NewsArticleEntity

class NewsListDiffCallback : DiffUtil.ItemCallback<NewsArticleEntity>() {

    override fun areItemsTheSame(oldItem: NewsArticleEntity, newItem: NewsArticleEntity): Boolean {
        return oldItem.author == newItem.author && oldItem.publishedAt == newItem.publishedAt
    }

    override fun areContentsTheSame(
        oldItem: NewsArticleEntity,
        newItem: NewsArticleEntity
    ): Boolean {
        return oldItem.author == newItem.author && oldItem.publishedAt == newItem.publishedAt
    }
}