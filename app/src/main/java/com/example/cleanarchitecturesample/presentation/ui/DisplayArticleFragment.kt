package com.example.cleanarchitecturesample.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cleanarchitecturesample.R
import com.example.cleanarchitecturesample.databinding.FragmentArticleDisplayBinding
import dagger.hilt.android.AndroidEntryPoint

// WIP Screen
@AndroidEntryPoint
class DisplayArticleFragment : Fragment(R.layout.fragment_article_display) {
    lateinit var binding: FragmentArticleDisplayBinding
    private val args: DisplayArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleDisplayBinding.bind(view)

        val article = args.article
    }
}
