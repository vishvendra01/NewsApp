package com.app.newsapp.ui.listing

import androidx.recyclerview.widget.DiffUtil
import com.app.newsapp.data.db.entity.NewsArticleEntity

class NewsListDiffCallback : DiffUtil.ItemCallback<NewsArticleEntity>() {

    override fun areItemsTheSame(oldItem: NewsArticleEntity, newItem: NewsArticleEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: NewsArticleEntity,
        newItem: NewsArticleEntity
    ): Boolean {
        return oldItem == newItem
    }
}