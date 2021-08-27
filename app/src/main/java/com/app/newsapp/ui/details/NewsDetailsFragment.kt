package com.app.newsapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.newsapp.data.db.entity.NewsArticleEntity
import com.app.newsapp.databinding.FragmentNewsDetailsBinding
import com.bumptech.glide.Glide

class NewsDetailsFragment : Fragment() {

    companion object {
        private const val EXTRA_NEWS_ARTICLE = "extras_article"

        fun newInstance(article: NewsArticleEntity): NewsDetailsFragment {
            val args = Bundle()
            args.putParcelable(EXTRA_NEWS_ARTICLE, article)
            val fragment = NewsDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val newsArticle: NewsArticleEntity? by lazy {
        requireArguments().getParcelable(
            EXTRA_NEWS_ARTICLE
        )
    }
    private lateinit var binding: FragmentNewsDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsArticle?.let { displayArticleDetails(it) }
    }

    private fun displayArticleDetails(article: NewsArticleEntity) {
        binding.newDescriptionTextView.text = article.description
        binding.titleTextView.text = article.title
        Glide.with(this).load(article.urlToImage).into(binding.newsPictureImageView)
    }
}