package com.example.data.remote

import com.example.data.model.ArticlesResponseItemEntity
import retrofit2.http.GET

interface ArticlesApi {

    @GET("articles")
    suspend fun getArticles(): List<ArticlesResponseItemEntity>
}
