package com.example.domain.repository

import com.example.domain.model.ArticlesResponseItem

interface ArticlesRepository {

    suspend fun getArticles(): List<ArticlesResponseItem>
}
