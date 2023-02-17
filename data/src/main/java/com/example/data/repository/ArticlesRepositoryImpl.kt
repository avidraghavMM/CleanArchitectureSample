package com.example.data.repository

import com.example.data.model.toDomain
import com.example.data.remote.ArticlesApi
import com.example.data.util.EmptyOrNullListException
import com.example.data.util.NetworkRequestFailedException
import com.example.domain.model.ArticlesResponseItem
import com.example.domain.repository.ArticlesRepository
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    private val api: ArticlesApi
) : ArticlesRepository {

    override suspend fun getArticles(): List<ArticlesResponseItem> {
        val response = api.getArticles()
        if (response.isSuccessful.not()) throw NetworkRequestFailedException

        val responseBody = response.body()
        if (responseBody.isNullOrEmpty()) throw EmptyOrNullListException

        return responseBody.map {
            it.toDomain()
        }
    }
}
