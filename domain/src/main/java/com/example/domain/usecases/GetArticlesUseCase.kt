package com.example.domain.usecases

import com.example.domain.model.ArticlesResponseItem
import com.example.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow

class GetArticlesUseCase(private val repository: ArticlesRepository) {

    suspend operator fun invoke(): Flow<List<ArticlesResponseItem>> {
        return repository.getArticles()
    }
}
