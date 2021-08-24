package com.app.newsapp.ui.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.newsapp.data.db.entity.NewsArticleEntity
import com.app.newsapp.databinding.ItemNewArticleBinding
import com.bumptech.glide.Glide

class NewsListingAdapter(diffCallback: NewsListDiffCallback) :
    ListAdapter<NewsArticleEntity, NewsListingAdapter.NewsListingViewHolder>(diffCallback) {

    class NewsListingViewHolder(val binding: ItemNewArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListingViewHolder {
        return NewsListingViewHolder(
            ItemNewArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsListingViewHolder, position: Int) {
        val article = getItem(position)
        article?.let {
            holder.binding.articleTitleTextView.text = it.title
            Glide.with(holder.binding.root)
                .load(it.urlToImage)
                .into(holder.binding.articlePictureImageView)
        }
    }
}