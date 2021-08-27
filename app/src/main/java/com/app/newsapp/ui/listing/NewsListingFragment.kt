package com.app.newsapp.ui.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.newsapp.data.db.entity.NewsArticleEntity
import com.app.newsapp.databinding.FragmentNewsListingBinding
import com.app.newsapp.utils.State
import com.app.newsapp.utils.gone
import com.app.newsapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListingFragment : Fragment() {

    private val newsListingViewModel: NewsListingViewModel by viewModels()
    private lateinit var binding: FragmentNewsListingBinding
    private val articlesListAdapter = NewsListingAdapter(NewsListDiffCallback()) {
        val action =
            NewsListingFragmentDirections.actionNewsListingFragmentToNewsDetailsFragment(it)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsListingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupArticlesRecyclerView()
        bindViews()
    }

    private fun setupArticlesRecyclerView() {
        binding.articlesRecyclerView.adapter = articlesListAdapter
        binding.articlesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun bindViews() {
        newsListingViewModel.getNewsArticles().observe(viewLifecycleOwner, {
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