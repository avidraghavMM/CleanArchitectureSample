package com.example.data.repository

import com.example.data.mapper.ArticlesDomainToDataMapper
import com.example.data.remote.ArticlesApi
import com.example.domain.model.ArticlesResponseItem
import com.example.domain.repository.ArticlesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticlesRepositoryImpl @Inject constructor(
    private val api: ArticlesApi,
    private val mapper: ArticlesDomainToDataMapper
) : ArticlesRepository {

    override suspend fun getArticles(): Flow<List<ArticlesResponseItem>> {
        val articles = api.getArticles().map {
            mapper.map(it)
        }
        return flow { emit(articles) }
    }
}
