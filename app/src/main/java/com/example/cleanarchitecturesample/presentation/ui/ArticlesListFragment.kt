package com.example.cleanarchitecturesample.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.cleanarchitecturesample.R
import com.example.cleanarchitecturesample.databinding.FragmentArticlesListBinding
import com.example.cleanarchitecturesample.util.Constants
import com.example.cleanarchitecturesample.util.UIState
import dagger.hilt.android.AndroidEntryPoint

/**
 * displays the list of articles received from the api
 */
@AndroidEntryPoint
class ArticlesListFragment : Fragment(R.layout.fragment_articles_list) {

    private val viewModel by viewModels<ArticlesListVM>()
    private lateinit var articlesAdapter: ArticlesAdapter
    private lateinit var binding: FragmentArticlesListBinding

    companion object {
        private const val TAG = "ArticlesListFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticlesListBinding.bind(view)
        setupRecyclerView()

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.articlesState.collect {
                when (it) {
                    UIState.Empty -> {
                        // state when the api call has not yet
                        // been initiated, in our case the api call
                        // get initiated as soon as ViewModel is instantiated but
                        // this will not always be the case
                    }
                    is UIState.Error -> {
                        showProgressBar(false)
                        showErrorMessage(true, it.exception.localizedMessage.orEmpty())
                    }
                    UIState.Loading -> {
                        showErrorMessage(false)
                        showProgressBar(true)
                    }
                    is UIState.Success -> {
                        showProgressBar(false)
                        articlesAdapter.differ.submitList(it.data)
                    }
                }
            }
        }

        articlesAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putParcelable(Constants.ARTICLE, it)
            }
            findNavController().navigate(
                R.id.action_articlesListFragment_to_articleDisplayFragment,
                bundle
            )
        }
        binding.btnRetry.setOnClickListener {
            viewModel.getArticles()
        }
    }

    private fun setupRecyclerView() {
        articlesAdapter = ArticlesAdapter()
        binding.rvArticles.adapter = articlesAdapter
    }

    private fun showProgressBar(show: Boolean) {
        binding.paginationProgressBar.visibility = if (show) View.VISIBLE else View.INVISIBLE
    }

    private fun showErrorMessage(show: Boolean, message: String = "") {
        if (show) {
            binding.itemErrorMessage.visibility = View.VISIBLE
            binding.tvErrorMessage.text = message
        } else {
            binding.itemErrorMessage.visibility = View.INVISIBLE
        }
    }
}
