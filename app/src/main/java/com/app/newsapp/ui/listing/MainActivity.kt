package com.app.newsapp.ui.listing

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.newsapp.data.db.entity.NewsArticleEntity
import com.app.newsapp.databinding.ActivityMainBinding
import com.app.newsapp.utils.State
import com.app.newsapp.utils.gone
import com.app.newsapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val newsListingViewModel: NewsListingViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val articlesListAdapter = NewsListingAdapter(NewsListDiffCallback())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupArticlesRecyclerView()
        bindViews()
    }

    private fun setupArticlesRecyclerView() {
        binding.articlesRecyclerView.adapter = articlesListAdapter
        binding.articlesRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun bindViews() {
        newsListingViewModel.getNewsArticles().observe(this, {
            renderNewsArticles(it)
        })
    }

    private fun renderNewsArticles(stateNewsArticles: State<List<NewsArticleEntity>>) {
        when (stateNewsArticles) {
            is State.Loading -> {
                binding.progressBar.visible()
            }

            is State.Success -> {
                binding.progressBar.gone()
                articlesListAdapter.submitList(stateNewsArticles.data)
            }
        }
    }
}