package com.example.domain.usecases

import com.example.domain.model.ArticlesResponseItem
import com.example.domain.repository.ArticlesRepository
import com.example.domain.util.Resource
import com.example.domain.util.safeCall

class GetArticlesUseCase(private val repository: ArticlesRepository) {

    suspend operator fun invoke(): Resource<List<ArticlesResponseItem>> =
        safeCall { repository.getArticles() }
}
