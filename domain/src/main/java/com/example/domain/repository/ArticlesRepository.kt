package com.example.domain.repository

import com.example.domain.model.ArticlesResponseItem
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    suspend fun getArticles(): Flow<List<ArticlesResponseItem>>
}
