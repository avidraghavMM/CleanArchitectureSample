package com.example.domain.model

data class ArticlesResponseItem(
    val events: List<Event?>?,
    val featured: Boolean?,
    val id: Int?,
    val imageUrl: String?,
    val launches: List<Launch?>?,
    val newsSite: String?,
    val publishedAt: String?,
    val summary: String?,
    val title: String?,
    val updatedAt: String?,
    val url: String?
)
