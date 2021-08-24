package com.app.newsapp.ui.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.app.newsapp.data.db.entity.NewsArticleEntity
import com.app.newsapp.data.repo.NewsRepository
import com.app.newsapp.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListingViewModel @Inject constructor(val newsRepository: NewsRepository) : ViewModel() {
    private val newsArticlesLiveData = newsRepository.getTopHeadlines().asLiveData()

    fun getNewsArticles(): LiveData<State<List<NewsArticleEntity>>> {
        return newsArticlesLiveData
    }
}